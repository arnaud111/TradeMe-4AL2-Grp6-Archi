package org.grp2.api.trademe.domain.dto.user.consultant;

import org.grp2.api.trademe.domain.dto.user.User;
import org.grp2.api.trademe.domain.dto.user.UserId;

public class Consultant extends User {

    private Skills skills;
    private Integer adr;
    private String availability;
    private String modality;

    public Consultant(UserId userId) {
        super(userId);
        this.skills = new Skills();
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
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
