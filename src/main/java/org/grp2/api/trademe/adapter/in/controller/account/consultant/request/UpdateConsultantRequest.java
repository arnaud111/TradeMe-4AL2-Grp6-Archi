package org.grp2.api.trademe.adapter.in.controller.account.consultant.request;

import java.util.ArrayList;

public class UpdateConsultantRequest {

    private String name;
    private String lastName;
    private Integer adr;
    private String availability;
    private String modality;
    private ArrayList<String> skills;

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
