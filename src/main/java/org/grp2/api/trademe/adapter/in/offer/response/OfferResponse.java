package org.grp2.api.trademe.adapter.in.offer.response;

public class OfferResponse {

    public final String offerId;
    public final String creatorAccountId;
    public final String title;
    public final String description;

    public OfferResponse(String offerId, String creatorAccountId, String title, String description) {
        this.offerId = offerId;
        this.creatorAccountId = creatorAccountId;
        this.title = title;
        this.description = description;
    }
}
