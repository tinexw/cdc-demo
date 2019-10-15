package de.tine.cdc.demo.userservice;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUser(String userId) {
        switch (userId) {
            case "1":
                return new User(userId, Integer.valueOf(userId), "Beth", "ADMIN");
            case "2":
                return new User(userId, Integer.valueOf(userId), "Matt", "USER");
            //case "3":
            //    return new User(userId, "8c511aa7-e89f-4f1c-9adb-8743bba6d892", "Ronja", "USER");
            default:
                throw new NotFoundException(String.format("User %d does not exist.", userId));
        }

    }
}
