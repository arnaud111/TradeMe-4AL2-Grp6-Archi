package org.grp2.api.trademe.adapter.in.consultant.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CreateConsultantRequest {

    private String email;
    private String password;
    private String name;
    private String lastName;
    @JsonProperty(required = false)
    private Integer adr;
    @JsonProperty(required = false)
    private String availability;
    @JsonProperty(required = false)
    private String modality;
    @JsonProperty(required = false)
    private ArrayList<String> skills;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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
