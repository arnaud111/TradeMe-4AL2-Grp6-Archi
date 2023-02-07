package org.grp2.api.trademe.adapter.in.controller.offer.request;

public class CreateOfferRequest {

    private String creatorAccountId;
    private String title;
    private String description;

    public String getCreatorAccountId() {
        return creatorAccountId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
