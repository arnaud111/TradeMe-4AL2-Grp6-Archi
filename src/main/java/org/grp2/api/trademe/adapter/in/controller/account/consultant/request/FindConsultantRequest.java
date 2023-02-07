package org.grp2.api.trademe.adapter.in.controller.account.consultant.request;

import java.util.ArrayList;

public class FindConsultantRequest {

    private String name;
    private String lastName;
    private Integer adrMin;
    private Integer adrMax;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAdrMin() {
        return adrMin;
    }

    public Integer getAdrMax() {
        return adrMax;
    }
}
