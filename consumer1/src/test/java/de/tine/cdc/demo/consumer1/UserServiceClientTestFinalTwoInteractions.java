package de.tine.cdc.demo.consumer1;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "user-service", port = "8082")
class UserServiceClientTestFinalTwoInteractions {

    private UserServiceClient userServiceClient = new UserServiceClient("http://localhost:8082");

    @Pact(consumer = "consumer1")
    RequestResponsePact pact(PactDslWithProvider builder) {
        return builder.uponReceiving("get user interaction")
                .method("GET")
                .path("/users/1")
                .willRespondWith()
                .status(200)
                .body(new PactDslJsonBody().stringType("name", "Beth")
                                .stringType("id", "1")
                                .numberType("externalId", 1))
                .toPact();
    }

    @Pact(consumer = "consumer1")
    RequestResponsePact pact2(PactDslWithProvider builder) {
        return builder.uponReceiving("get user interaction - not found")
                .method("GET")
                .path("/users/unknown")
                .willRespondWith()
                .status(404)
                .toPact();
    }

    @Test
    void getUser() {
        User user = userServiceClient.getUser("1");
        assertThat(user.getName()).isEqualTo("Beth");
    }

    @PactTestFor(pactMethod = "pact2")
    @Test
    void getUser_notFound() {
        assertThatThrownBy(() -> userServiceClient.getUser("unknown")).hasMessageContaining("404 Not Found");
    }
}