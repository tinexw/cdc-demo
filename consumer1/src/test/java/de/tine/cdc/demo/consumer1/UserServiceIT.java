package de.tine.cdc.demo.consumer1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

@Disabled
public class UserServiceIT {

    @Test
    void userExists() {
        WebTestClient webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8090")
                .build();

        webTestClient
                .get()
                .uri("/users/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.externalId").isEqualTo(1L)
                .jsonPath("$.name").isEqualTo("Beth");
    }
}
