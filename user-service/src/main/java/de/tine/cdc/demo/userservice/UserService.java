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
                        .role("ADMIN")
                        .build();
            case "2":
                return User.builder()
                        .id(userId)
                        .externalId(Integer.valueOf(userId))
                        .name("Matt")
                        .role("USER")
                        .build();
//            case "3":
//                return User.builder()
//                        .id(userId)
//                        .externalId("8c511aa7-e89f-4f1c-9adb-8743bba6d892")
//                        .name("Ronja")
//                        .role("USER")
//                        .build();
            default:
                throw new NotFoundException(String.format("User %d does not exist.", userId));
        }

    }
}
