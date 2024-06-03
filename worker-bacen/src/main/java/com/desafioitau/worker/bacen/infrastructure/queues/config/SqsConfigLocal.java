package com.desafioitau.worker.bacen.infrastructure.queues.config;

import io.awspring.cloud.sqs.config.SqsBootstrapConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import static java.net.URI.create;
import static software.amazon.awssdk.regions.Region.US_EAST_1;
import static software.amazon.awssdk.services.sqs.SqsAsyncClient.builder;

@Configuration
@Import(SqsBootstrapConfiguration.class)
public class SqsConfigLocal {

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return builder()
                .endpointOverride(create("http://localhost:4566"))
                .region(US_EAST_1)
                .build();
    }
}
