package org.grp2.api.trademe.adapter.in.account.client.response;

public class ClientResponse {

    public final String accountId;
    public final String email;
    public final String name;
    public final String lastName;

    public ClientResponse(String accountId, String email, String name, String lastName) {
        this.accountId = accountId;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }
}
