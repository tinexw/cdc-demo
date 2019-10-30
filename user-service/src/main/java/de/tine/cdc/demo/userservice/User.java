package de.tine.cdc.demo.userservice;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

    private String id;
    private String externalId;
    private String name;
    private String role;
}
