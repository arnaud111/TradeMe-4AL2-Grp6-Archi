package org.grp2.api.trademe.adapter.out.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONSULTANT")
public class ConsultantEntity {

    @Id
    @Column(unique = true, nullable = false, length=36)
    private String id;

    @Column(length=256, nullable = false)
    private String email;

    @Column(length=256, nullable = false)
    private String password;

    @Column(length=256, nullable = false)
    private String name;

    @Column(length=256, nullable = false)
    private String lastName;

    private Integer adr;

    @Column(length=32)
    private String availability;

    @Column(length=32)
    private String modality;

    public ConsultantEntity() {
    }

    public ConsultantEntity(String id, String email, String password, String name, String lastName, Integer adr, String availability, String modality) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.adr = adr;
        this.availability = availability;
        this.modality = modality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
