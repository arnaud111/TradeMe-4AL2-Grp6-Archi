package org.grp2.api.trademe.adapter.out;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "T_ACCOUNT")
public class ConsultantEntity {

    @Id
    private String id;

    @ElementCollection
    private List<EventEntity> recordedEvents;

    public ConsultantEntity() {
    }

    public ConsultantEntity(String id, List<EventEntity> recordedEvents) {
        this.id = id;
        this.recordedEvents = recordedEvents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<EventEntity> getRecordedEvents() {
        return recordedEvents;
    }

    public void setRecordedEvents(List<EventEntity> recordedEvents) {
        this.recordedEvents = recordedEvents;
    }
}
