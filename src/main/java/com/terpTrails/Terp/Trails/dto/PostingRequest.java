package com.terpTrails.Terp.Trails.dto;

import java.util.List;

public class PostingRequest {

    private String title;
    private String description;
    private String paidOrUnpaid;
    private String ageRange;
    private List<String> requirements;

    // New field: if true, user can provide extra requirements (up to 5).
    private boolean allowExtraRequirements;

    private String startDate;
    private String endDate;

    private String postedDate;

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getPaidOrUnpaid() {
        return paidOrUnpaid;
    }

    public void setPaidOrUnpaid(String paidOrUnpaid) {
        this.paidOrUnpaid = paidOrUnpaid;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public boolean isAllowExtraRequirements() {
        return allowExtraRequirements;
    }

    public void setAllowExtraRequirements(boolean allowExtraRequirements) {
        this.allowExtraRequirements = allowExtraRequirements;
    }
}
