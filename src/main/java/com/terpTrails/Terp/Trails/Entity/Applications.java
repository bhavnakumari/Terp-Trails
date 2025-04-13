package com.terpTrails.Terp.Trails.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Applications {
    @Id
    private String id;

    @DBRef
    private VolunteerRegistration volunteer;  // The volunteer who applied

    @DBRef
    private Posting posting;      // The posting the volunteer applied for

    private LocalDateTime dateApplied;

    // Optional: additional fields (status, comments, etc.)
    private String status;  // Example: "Pending", "Reviewed", etc.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolunteerRegistration getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(VolunteerRegistration volunteer) {
        this.volunteer = volunteer;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    public LocalDateTime getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDateTime dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
