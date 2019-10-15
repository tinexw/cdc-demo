package de.tine.cdc.demo.userservice;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUser(int userId) {
        switch (userId) {
            case 1:
                return new User(userId, "Beth", "ADMIN");
            case 2:
                return new User(userId, "Matt", "USER");
            default:
                throw new NotFoundException(String.format("User %d does not exist.", userId));
        }

    }
}
