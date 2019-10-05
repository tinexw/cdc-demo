package de.tine.cdc.demo.userservice;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findUser(Long userId) {
        return new User(userId, "Beth");
    }
}
