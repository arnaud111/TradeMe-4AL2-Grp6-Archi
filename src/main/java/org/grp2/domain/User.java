package org.grp2.domain;

import java.util.UUID;

public class User {

    private final UserId userId;
    private String email;
    private String password;
    private String name;
    private String lastName;

    public User(UserId userId) {
        this.userId = userId;
    }

    public User(UserId userId, String email, String password, String name, String lastName) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public User(UUID userId, String email, String password, String name, String lastName) {
        this.userId = UserId.of(userId);
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

    public UserId id() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}