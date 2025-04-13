package com.terpTrails.Terp.Trails.Entity;


import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "postings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posting {

    // Instead of storing the whole ResearchFirm, you store its ID.
    private String researchFirmId;

    @Id
    private String id;

    // Basic details
    private String postTitle;
    private String postDescription;

    // New fields:
    private String paidOrUnpaid; // "Paid" or "Unpaid"
    private String ageRange;     // e.g., "18-35"
    private List<String> requirements;  // List of extra requirements (up to 5)
    private boolean allowExtraRequirements; // If true, extra requirements are allowed

    // Timestamp for when the post was created.
    private String postedAt;
    private String startDate;
    private String endDate;

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

    public String getResearchFirmId() {
        return researchFirmId;
    }

    public void setResearchFirmId(String researchFirmId) {
        this.researchFirmId = researchFirmId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
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

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }
}
