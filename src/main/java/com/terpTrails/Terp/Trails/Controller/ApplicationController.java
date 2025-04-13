package com.terpTrails.Terp.Trails.Controller;

import com.terpTrails.Terp.Trails.Entity.RecommenderResponse;
import com.terpTrails.Terp.Trails.dto.ApplicationRequest;
import com.terpTrails.Terp.Trails.dto.RecommendRequest;
import com.terpTrails.Terp.Trails.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;



    // Endpoint for a volunteer to apply for a posting
    @PostMapping("/apply")
    public ResponseEntity<?> apply(@RequestBody ApplicationRequest request) {
        return applicationService.applyForPosting(request);
    }

    // Endpoint to retrieve all applications for a given posting
    @GetMapping("/by-posting/{postingId}")
    public ResponseEntity<?> getApplicationsByPosting(@PathVariable String postingId) {
        return applicationService.getApplicationsForPosting(postingId);
    }




}
