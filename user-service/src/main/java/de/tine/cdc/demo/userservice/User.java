package de.tine.cdc.demo.userservice;

public class User {

    private final String id;
    private final int newId;
    private final String name;
    private final String role;

    public User(String id, int newId, String name, String role) {
        this.id = id;
        this.newId = newId;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public int getNewId() {
        return newId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
