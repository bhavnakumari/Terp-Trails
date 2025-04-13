package com.terpTrails.Terp.Trails.dto;

import lombok.Data;

@Data
public class RecommendRequest {

    private String requirement;

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
