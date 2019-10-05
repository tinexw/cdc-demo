package de.tine.cdc.demo.consumer1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class Consumer1UserController {

    private final UserServiceClient userServiceClient;

    public Consumer1UserController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/consumer1/users")
    public List<User> getUser() {
        return Collections.singletonList(userServiceClient.getUser(1L));
    }

}
