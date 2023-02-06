package org.grp2.api.trademe.domain.event.account.consultant;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.kernel.Event;

import java.util.ArrayList;

public class ConsultantUpdated implements Event {

    private final AccountId accountId;
    private final String name;
    private final String lastName;
    private final Integer adr;
    private final String availability;
    private final String modality;
    private final ArrayList<String> skills;

    public ConsultantUpdated(AccountId accountId, String name, String lastName, Integer adr, String availability, String modality, ArrayList<String> skills) {
        this.accountId = accountId;
        this.name = name;
        this.lastName = lastName;
        this.adr = adr;
        this.availability = availability;
        this.modality = modality;
        this.skills = skills;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAdr() {
        return adr;
    }

    public String getAvailability() {
        return availability;
    }

    public String getModality() {
        return modality;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }
}
