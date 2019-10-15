package de.tine.cdc.demo.consumer1;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

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
                .jsonPath("$.name").isEqualTo("Beth");
    }
}
