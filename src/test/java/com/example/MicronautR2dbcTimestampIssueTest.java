package com.example;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import java.time.Instant;

@MicronautTest
public class MicronautR2dbcTimestampIssueTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    ModelRepository repository;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
        Mono.from(repository.save(new Model(Instant.EPOCH))).block();
    }

}
