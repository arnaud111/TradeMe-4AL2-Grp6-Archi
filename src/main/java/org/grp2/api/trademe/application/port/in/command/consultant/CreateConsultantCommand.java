package org.grp2.api.trademe.application.port.in.command.consultant;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public final class CreateConsultantCommand implements Command {

    @NotNull
    public final String email;

    @NotNull
    public final String password;

    @NotNull
    public final String name;

    @NotNull
    public final String lastName;

    public final Integer adr;

    public final String availability;

    public final String modality;

    public final ArrayList<String> skills;

    public CreateConsultantCommand(String email, String password, String name, String lastName, Integer adr, String availability, String modality, ArrayList<String> skills) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.adr = adr;
        this.availability = availability;
        this.modality = modality;
        this.skills = skills;
    }
}
