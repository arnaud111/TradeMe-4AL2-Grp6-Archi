package org.grp2.api.trademe.domain.dto.offer;

import org.grp2.api.trademe.domain.dto.account.AccountId;
import org.grp2.api.trademe.domain.event.offer.OfferCreated;
import org.grp2.kernel.Event;

import java.util.ArrayList;
import java.util.List;

public class Offer {

    private final OfferId offerId;

    private AccountId creatorAccountId;

    private String title;

    private String description;

    private final List<Event> recordedEvents;

    public Offer(OfferId offerId, AccountId accountId) {
        this.offerId = offerId;
        this.creatorAccountId = accountId;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new OfferCreated(offerId));
    }

    public AccountId getCreatorAccountId() {
        return creatorAccountId;
    }

    public void setCreatorAccountId(AccountId creatorAccountId) {
        this.creatorAccountId = creatorAccountId;
    }

    public OfferId getOfferId() {
        return offerId;
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

    public List<Event> getRecordedEvents() {
        return recordedEvents;
    }

    public void addRecordedEvents(Event event) {
        recordedEvents.add(event);
    }
}
