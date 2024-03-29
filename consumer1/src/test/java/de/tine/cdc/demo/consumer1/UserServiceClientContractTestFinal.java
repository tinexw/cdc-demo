package de.tine.cdc.demo.consumer1;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
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
public class UserServiceClientContractTestFinal {

    @Autowired
    private UserServiceClient userServiceClient;

    @Pact(consumer = "consumer1")
    public RequestResponsePact createContract(PactDslWithProvider builder) {
        return builder
                .uponReceiving("get user interaction")
                .method("GET")
                .path("/users/1")
                .willRespondWith()
                .status(200)
                .body(new PactDslJsonBody()
                                .stringType("id", "1")
                                .stringType("name", "Beth")
                                .numberType("externalId", 1L)
                )
                .toPact();
    }

    @Test
    public void userExists() {
        User user = userServiceClient.getUser("1");

        assertThat(user.getName()).isEqualTo("Beth");
    }
}
