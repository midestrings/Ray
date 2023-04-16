package com.ray.app.util.schedule;


import com.ray.app.grpc.ScheduleServiceGrpc;
import com.ray.app.util.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jmdns.ServiceInfo;
import static com.ray.app.Main.getAuth;

public class ScheduleUtil {
    private ScheduleUtil() {}

    private static final Logger LOG = LogManager.getLogger(ScheduleUtil.class);
    private static ScheduleServiceGrpc.ScheduleServiceBlockingStub serviceStub;
    @SuppressWarnings("deprecation")
    public static void setServiceStub(ServiceInfo info) {
        LOG.info("IP Resolved for schedule_service - " + info.getPort() + ":" + info.getHostAddress());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(info.getHostAddress(), info.getPort()).usePlaintext().build();
        serviceStub = ScheduleServiceGrpc.newBlockingStub(channel);
    }



    public static void removeScheduleStub() {
        serviceStub = null;
    }
}
