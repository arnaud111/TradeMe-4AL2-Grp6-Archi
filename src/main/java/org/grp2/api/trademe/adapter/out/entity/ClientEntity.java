package org.grp2.api.trademe.adapter.out.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class ClientEntity extends AccountEntity implements Serializable {

    public ClientEntity() {
    }

    public ClientEntity(String id, String email, String password, String name, String lastName, List<EventEntity> recordedEvents) {
        super(id, email, password, name, lastName, recordedEvents);
    }
}
