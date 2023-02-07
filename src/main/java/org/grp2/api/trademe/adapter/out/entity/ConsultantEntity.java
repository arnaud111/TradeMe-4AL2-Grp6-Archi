package org.grp2.api.trademe.adapter.out.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CONSULTANT")
public class ConsultantEntity extends AccountEntity implements Serializable {

    private Integer adr;

    @Column(length=32)
    private String availability;

    @Column(length=32)
    private String modality;

    @ElementCollection
    private List<String> skills;

    public ConsultantEntity() {
    }

    public ConsultantEntity(String id, String email, String password, String name, String lastName, List<EventEntity> recordedEvents, Integer adr, String availability, String modality, List<String> skills) {
        super(id, email, password, name, lastName, recordedEvents);
        this.adr = adr;
        this.availability = availability;
        this.modality = modality;
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

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
