package de.tine.cdc.demo.consumer1;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "user-service", port = "8081")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = "user-service.base-url:http://localhost:8081",
        classes = UserServiceClient.class)
public class UserServiceClientContractTest {

    @Autowired
    private UserServiceClient userServiceClient;

    @Pact(consumer = "consumer1")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("User 1 exists")
                .uponReceiving("get user interaction")
                .method("GET")
                .path("/users/1")
                .willRespondWith()
                .status(200)
                .body(LambdaDsl.newJsonBody((o) ->
                        o
                                .stringType("id", "1")
                                .numberType("newId", 1)
                                .stringType("name", "Beth")
                ).build())
                .toPact();
    }

    @Test
    public void userExists() {
        User user = userServiceClient.getUser(1L);

        assertThat(user.getName()).isEqualTo("Beth");
    }
}
