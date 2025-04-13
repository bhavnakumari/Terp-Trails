package com.terpTrails.Terp.Trails.dto;

public class ApplicationRequest {
    private String postingId;    // The ID of the posting
    private String volunteerId;  // The ID of the volunteer
    //private String comments;     // Optional comments by the volunteer

    public String getPostingId() {
        return postingId;
    }

    public void setPostingId(String postingId) {
        this.postingId = postingId;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

}
