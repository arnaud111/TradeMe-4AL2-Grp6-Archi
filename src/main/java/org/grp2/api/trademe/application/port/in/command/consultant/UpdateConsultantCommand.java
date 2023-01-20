package org.grp2.api.trademe.application.port.in.command.consultant;

import org.grp2.kernel.Command;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class UpdateConsultantCommand implements Command {

    @NotNull
    public final String id;

    public final String name;

    public final String lastName;

    public final Integer adr;

    public final String availability;

    public final String modality;

    public final ArrayList<String> skills;


    public UpdateConsultantCommand(String id, String name, String lastName, Integer adr, String availability, String modality, ArrayList<String> skills) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.adr = adr;
        this.availability = availability;
        this.modality = modality;
        this.skills = skills;
    }
}
