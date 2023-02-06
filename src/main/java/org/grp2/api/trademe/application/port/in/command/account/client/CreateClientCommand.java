package org.grp2.api.trademe.application.port.in.command.account.client;

import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;

public class CreateClientCommand implements Command {

    @NotNull
    public final String email;

    @NotNull
    public final String password;

    @NotNull
    public final String name;

    @NotNull
    public final String lastName;

    public CreateClientCommand(String email, String password, String name, String lastName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }
}
