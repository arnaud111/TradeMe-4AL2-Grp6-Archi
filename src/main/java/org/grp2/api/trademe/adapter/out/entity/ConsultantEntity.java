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

    public ConsultantEntity() {
    }

    public ConsultantEntity(String id, String email, String password, String name, String lastName, List<EventEntity> recordedEvents, String id1, Integer adr, String availability, String modality) {
        super(id, email, password, name, lastName, recordedEvents);
        this.adr = adr;
        this.availability = availability;
        this.modality = modality;
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
