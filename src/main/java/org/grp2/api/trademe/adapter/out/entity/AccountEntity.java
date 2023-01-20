package org.grp2.api.trademe.adapter.out.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {
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

    @ElementCollection
    private List<EventEntity> recordedEvents;

    public AccountEntity() {}

    public AccountEntity(String id, String email, String password, String name, String lastName, List<EventEntity> recordedEvents) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.recordedEvents = recordedEvents;
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

    public List<EventEntity> getRecordedEvents() {
        return recordedEvents;
    }

    public void setRecordedEvents(List<EventEntity> recordedEvents) {
        this.recordedEvents = recordedEvents;
    }
}
