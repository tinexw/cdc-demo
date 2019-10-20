package de.tine.cdc.demo.userservice;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUser(String userId) {
        switch (userId) {
            case "1":
                return User.builder()
                        .id(userId)
                        .externalId(Integer.valueOf(userId))
                        .name("Beth")
                        .build();
            case "2":
                return User.builder()
                        .id(userId)
                        .externalId(Integer.valueOf(userId))
                        .name("Matt")
                        .build();
            default:
                throw new NotFoundException(String.format("User %s does not exist.", userId));
        }

    }
}
