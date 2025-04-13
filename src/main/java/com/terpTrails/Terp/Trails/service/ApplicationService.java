package com.terpTrails.Terp.Trails.service;

import com.terpTrails.Terp.Trails.Entity.Applications;
import com.terpTrails.Terp.Trails.Entity.Posting;
import com.terpTrails.Terp.Trails.Entity.VolunteerRegistration;
import com.terpTrails.Terp.Trails.Repository.ApplicationRepository;
import com.terpTrails.Terp.Trails.Repository.PostingRepository;
import com.terpTrails.Terp.Trails.Repository.VolunteerRepository;
import com.terpTrails.Terp.Trails.dto.ApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private PostingRepository postingRepository;

    @Autowired
    private VolunteerRepository volunteerRepository;


    public ResponseEntity<?> applyForPosting(ApplicationRequest request) {
        String postingId = request.getPostingId();
        String volunteerId = request.getVolunteerId();
        // Retrieve posting by ID

        Optional<Posting> optionalPosting = postingRepository.findById(postingId);
        if (!optionalPosting.isPresent()) {
            return ResponseEntity.badRequest().body("Invalid posting ID");
        }
        Posting posting = optionalPosting.get();

        // Retrieve volunteer by ID
        Optional<VolunteerRegistration> optionalVolunteer = volunteerRepository.findById(volunteerId);
        if (!optionalVolunteer.isPresent()) {
            return ResponseEntity.badRequest().body("Invalid volunteer ID");
        }
        VolunteerRegistration volunteer = optionalVolunteer.get();

        // Create and save the application
        Applications application = new Applications();
        application.setPosting(posting);
        application.setVolunteer(volunteer);
        application.setDateApplied(LocalDateTime.now());
        application.setStatus("Applied");

        applicationRepository.save(application);
        return ResponseEntity.ok("Application submitted successfully");
    }

    public ResponseEntity<?> getApplicationsForPosting(String postingId) {
        List<Applications> applications = applicationRepository.findByPostingId(postingId);
        return ResponseEntity.ok(applications);
    }

}
