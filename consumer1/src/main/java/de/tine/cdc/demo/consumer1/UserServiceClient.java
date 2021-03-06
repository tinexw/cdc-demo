package de.tine.cdc.demo.consumer1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Component
public class UserServiceClient {

    private final RestTemplate restTemplate;

    public UserServiceClient(@Value("${user-service.base-url}") String baseUrl) {
        this.restTemplate = new RestTemplateBuilder().rootUri(baseUrl).build();
    }

    public User getUser(String id) {
        final User user = restTemplate.getForObject("/users/" + id, User.class);
        Assert.hasText(user.getName(), "Name is blank.");
        Assert.hasText(user.getId(), "Id is blank.");
        Assert.notNull(user.getExternalId(), "External id is null.");
        return user;
    }

}
