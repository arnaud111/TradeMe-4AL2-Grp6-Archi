package org.grp2.api.trademe.application.port.in.command.account.consultant;

import org.grp2.kernel.Command;

import java.util.ArrayList;
import java.util.List;

public class FindAllMatchConsultantCommand implements Command {

    public final String name;
    public final String lastName;
    public final Integer adrMin;
    public final Integer adrMax;

    public FindAllMatchConsultantCommand(String name, String lastName, Integer adrMin, Integer adrMax) {
        this.name = name;
        this.lastName = lastName;
        this.adrMin = adrMin;
        this.adrMax = adrMax;
    }
}
