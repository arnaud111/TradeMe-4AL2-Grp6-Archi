package org.grp2.api.trademe.adapter.in.account.client.request;

public class CreateClientRequest {

    private String email;
    private String password;
    private String name;
    private String lastName;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
