package com.terpTrails.Terp.Trails.Controller;

import com.terpTrails.Terp.Trails.Entity.Applications;
import com.terpTrails.Terp.Trails.Entity.RecommenderResponse;
import com.terpTrails.Terp.Trails.dto.ApplicationRequest;
import com.terpTrails.Terp.Trails.dto.PostingWithApplicantsDTO;
import com.terpTrails.Terp.Trails.dto.RecommendRequest;
import com.terpTrails.Terp.Trails.service.ApplicationService;
import com.terpTrails.Terp.Trails.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PostingService postingService;



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

    @PostMapping("/calculateScorePercentage")
    public ResponseEntity<Integer> calculateScorePercentage(@RequestBody List<Integer> responses) {
        int total = responses.size();
        if (total == 0) {
            return ResponseEntity.ok(0); // Avoid division by zero
        }

        int sum = responses.stream().mapToInt(Integer::intValue).sum();
        int percentage = (int) Math.round((sum * 100.0) / total);

        return ResponseEntity.ok(percentage);
    }
    //@GetMapping("/by-firm")
    public ResponseEntity<List<Applications>> getApplicantsByFirm(@RequestParam String firmId) {
        return applicationService.getApplicantsForFirm(firmId);
    }

    @GetMapping("/by-firm")
    public ResponseEntity<List<PostingWithApplicantsDTO>> getFirmPostingsWithApplicants(@RequestParam String firmId) {
        return postingService.getFirmPostingsWithApplicants(firmId);
    }

}
