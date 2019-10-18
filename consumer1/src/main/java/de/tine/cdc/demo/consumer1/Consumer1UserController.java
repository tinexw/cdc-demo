package de.tine.cdc.demo.consumer1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Consumer1UserController {

    private final UserServiceClient userServiceClient;

    public Consumer1UserController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return Arrays.asList(userServiceClient.getUser("1"), userServiceClient.getUser("2")
                //        , userServiceClient.getUser("3")
        );
    }

}
