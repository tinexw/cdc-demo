package de.tine.cdc.demo.userservice;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUser(String userId) {
        switch (userId) {
            case "1":
                return User.builder()
                        .id(userId)
                        .externalId(userId)
                        .name("Beth")
                        .build();
            case "2":
                return User.builder()
                        .id(userId)
                        .externalId(userId)
                        .name("Matt")
                        .build();
            case "3":
                return User.builder()
                        .id(userId)
                        .externalId("d8b34c23-2fd6-41b6-b048-7d1581345578")
                        .name("Ronja")
                        .build();
            default:
                throw new NotFoundException(String.format("User %s does not exist.", userId));
        }

    }
}
