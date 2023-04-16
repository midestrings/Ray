package com.ray.user.util.auth;


import io.grpc.*;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.List;

import static com.ray.user.UserInfoServer.getProperties;
import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public class AuthorizationServerInterceptor implements ServerInterceptor {
    private static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("Authorization", ASCII_STRING_MARSHALLER);
    private static final String BEARER_TYPE = "Bearer";
    private static final JwtParser parser = Jwts.parserBuilder().setSigningKey(new SecretKeySpec(Base64.getDecoder().decode(getProperties().getProperty("jwt_secret_key")), SignatureAlgorithm.HS256.getJcaName())).build();
    private static final Context.Key<String> PRINCIPAL = Context.key("principal");
    private static final List<String> authenticatedMethods = List.of("getUser", "getAllUser");


    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        String fullMethodName = serverCall.getMethodDescriptor().getFullMethodName();
        if (!authenticatedMethods.contains(fullMethodName.split("/")[1])) {
            Context ctx = Context.current().withValue(PRINCIPAL, "Anonymous");
            return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
        }
        String value = metadata.get(AUTHORIZATION_METADATA_KEY);

        Status status;
        if (value == null) {
            status = Status.UNAUTHENTICATED.withDescription("Authorization token is missing");
        } else if (!value.startsWith(BEARER_TYPE)) {
            status = Status.UNAUTHENTICATED.withDescription("Unknown authorization type");
        } else {
            try {
                String token = value.substring(BEARER_TYPE.length()).trim();
                Jws<Claims> claims = parser.parseClaimsJws(token);
                Context ctx = Context.current().withValue(PRINCIPAL, claims.getBody().getSubject());
                return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
            } catch (Exception e) {
                status = Status.UNAUTHENTICATED.withDescription(e.getMessage()).withCause(e);
            }
        }

        serverCall.close(status, metadata);
        return new ServerCall.Listener<ReqT>() {
            // noop
        };
    }
}
