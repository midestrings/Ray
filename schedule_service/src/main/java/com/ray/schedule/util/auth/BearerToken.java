package com.ray.schedule.util.auth;


import io.grpc.*;

import java.util.concurrent.Executor;
import java.util.function.Supplier;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public class BearerToken implements CallCredentials {
    public static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("Authorization", ASCII_STRING_MARSHALLER);
    private final String value;

    public BearerToken(Supplier<String> supplier) {
        this.value = supplier.get();
    }

    @Override
    public void applyRequestMetadata(MethodDescriptor<?, ?> methodDescriptor, Attributes attributes, Executor executor, MetadataApplier metadataApplier) {
        executor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                headers.put(AUTHORIZATION_METADATA_KEY, String.format("%s %s", "Bearer", value));
                metadataApplier.apply(headers);
            } catch (Throwable e) {
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }

    @Override
    public void thisUsesUnstableApi() {
        // noop
    }
}
