package org.grp2.api.trademe.adapter.out.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "OFFER")
public class OfferEntity implements Serializable {

    @Id
    @Column(unique = true, nullable = false, length=36)
    private String id;

    @Column(nullable = false, length=36)
    private String creatorAccountId;

    @Column(length=256, nullable = false)
    private String title;

    @Column(length=256, nullable = false)
    private String description;

    @ElementCollection
    private List<EventEntity> recordedEvents;

    public OfferEntity() {}

    public OfferEntity(String id, String creatorAccountId, String title, String description, List<EventEntity> recordedEvents) {
        this.id = id;
        this.creatorAccountId = creatorAccountId;
        this.title = title;
        this.description = description;
        this.recordedEvents = recordedEvents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatorAccountId() {
        return creatorAccountId;
    }

    public void setCreatorAccountId(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EventEntity> getRecordedEvents() {
        return recordedEvents;
    }

    public void setRecordedEvents(List<EventEntity> recordedEvents) {
        this.recordedEvents = recordedEvents;
    }
}
