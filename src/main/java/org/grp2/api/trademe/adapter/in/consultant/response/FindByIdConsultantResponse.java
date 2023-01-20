package org.grp2.api.trademe.adapter.in.consultant.response;

import java.util.ArrayList;

public class FindByIdConsultantResponse {

    public final String accountId;
    public final Integer adr;
    public final String availability;
    public final String modality;
    public final String email;
    public final String name;
    public final String lastName;
    public final ArrayList<String> skills;

    public FindByIdConsultantResponse(String accountId, Integer adr, String availability, String modality, String email, String name, String lastName, ArrayList<String> skills) {
        this.accountId = accountId;
        this.adr = adr;
        this.availability = availability;
        this.modality = modality;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.skills = skills;
    }
}
