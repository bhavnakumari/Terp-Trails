package com.terpTrails.Terp.Trails.dto;

import com.example.terpTrails.Terp.Trails.dto.ParticipantDTO;

import java.util.List;

public class PostingWithApplicantsDTO {

    private String postingid;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String compensation;
    private List<com.example.terpTrails.Terp.Trails.dto.ParticipantDTO> participants;

    public PostingWithApplicantsDTO() {
        this.postingid = postingid;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.compensation = compensation;
        this.participants = participants;
    }

    public String getPostingid() {
        return postingid;
    }

    public void setPostingid(String postingid) {
        this.postingid = postingid;
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

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public List<ParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDTO> participants) {
        this.participants = participants;
    }
}
