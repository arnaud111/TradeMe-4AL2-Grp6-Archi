package org.grp2.api.trademe.domain.dto.account.consultant;

import org.grp2.api.trademe.domain.dto.account.Account;
import org.grp2.api.trademe.domain.dto.account.AccountId;

import java.util.ArrayList;

public class Consultant extends Account {

    private ArrayList<String> skills;
    private Integer adr;
    private String availability;
    private String modality;

    public Consultant(AccountId accountId) {
        super(accountId);
        this.skills = new ArrayList<String>();
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public Integer getAdr() {
        return adr;
    }

    public void setAdr(Integer adr) {
        this.adr = adr;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }
}
