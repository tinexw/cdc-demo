package de.tine.cdc.demo.consumer1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = "user-service.base-url:http://localhost:8081",
        classes = UserServiceClient.class)
class UserServiceClientTestSkeleton {

    @Autowired
    private UserServiceClient userServiceClient;

    @Test
    void getUser() {
        User user = userServiceClient.getUser("1");

        assertEquals("Beth", user.getName());
    }
}