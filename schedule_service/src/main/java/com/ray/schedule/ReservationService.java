package com.ray.schedule;

import com.ray.schedule.entity.ReservationEntity;
import com.ray.schedule.grpc.Email;
import com.ray.schedule.grpc.Reservation;
import com.ray.schedule.grpc.ReservationFilter;
import com.ray.schedule.grpc.Vehicle;
import com.ray.schedule.util.Type;
import com.ray.schedule.util.Utility;
import com.ray.schedule.util.email.EmailUtil;
import com.ray.schedule.util.hibernate.EntityService;
import com.ray.schedule.util.hibernate.HibernateUtil;
import com.ray.schedule.util.vehicle.VehicleUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ReservationService {
    private static final Logger LOG = LogManager.getLogger(ReservationService.class);
    private final EntityService<ReservationEntity> reservationService = new EntityService<>(ReservationEntity.class);

    public Optional<Reservation> create(Reservation reservation) {
        try {
          validateReservation(reservation);
          var vehicle = VehicleUtil.confirmVehicleAvailability(reservation.getVehicleId()).orElseThrow();
          if ((Type.Ride.equals(reservation.getType()) && vehicle.getIsAvailableForRideHailing()) || (Type.Rent.equals(reservation.getType()) && vehicle.getIsAvailableForRent())) {
              var reservationEntity = ReservationEntity.getInstance(reservation);
              reservationEntity.setVehicleId(vehicle.getId());
              reservationEntity.setVehiclePlateNo(vehicle.getPlateNo());

              reservationService.save(reservationEntity);
              EmailUtil.sendEmail("Vehicle scheduled", vehicle.getOwnerEmail(), getScheduleMessage(reservationEntity));
              return Optional.of(ReservationEntity.getReservation(reservationEntity));
          }
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public List<Reservation> getReservations(ReservationFilter filter) {
        return new LinkedList<>();
    }

    public Optional<Reservation> update(Reservation reservation) {
        try {
          var savedReservation = reservationService.getById(reservation.getId()).orElseThrow();
          ReservationEntity.updateInstance(savedReservation, reservation);
          reservationService.update(savedReservation);
          return Optional.of(ReservationEntity.getReservation(savedReservation));
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public Optional<Reservation> getReservation(Reservation reservation) {
        return reservationService.getById(reservation.getId()).map(ReservationEntity::getReservation);
    }
    private void validateReservation(Reservation reservation) {
        if (!Type.types.contains(reservation.getType())) throw new RuntimeException("Invalid reservation type");
        if (Utility.isEmpty(reservation.getClientEmail())) throw new RuntimeException("Client email can't be empty");
    }

    private String getScheduleMessage(ReservationEntity reservation) {
        var builder = new StringBuilder("Your vehicle has been scheduled for ")
                .append(reservation.getType()).append(" by ")
                .append(reservation.getClientName()).append(" on ");
        if (Type.Ride.equals(reservation.getType())) {
            builder.append(reservation.getPickupTime()).append(" at ")
                    .append(reservation.getPickupAddress());
        } else {
            builder.append(reservation.getDropOffTime()).append(" at ")
                    .append(reservation.getDropOffAddress());
        }
        return builder.toString();
    }
}
