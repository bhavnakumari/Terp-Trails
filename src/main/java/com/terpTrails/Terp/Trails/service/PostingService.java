package com.terpTrails.Terp.Trails.service;


import com.example.terpTrails.Terp.Trails.dto.ParticipantDTO;
import com.terpTrails.Terp.Trails.Entity.Applications;
import com.terpTrails.Terp.Trails.Entity.FirmRegistration;
import com.terpTrails.Terp.Trails.Entity.Posting;
import com.terpTrails.Terp.Trails.Entity.VolunteerRegistration;
import com.terpTrails.Terp.Trails.Repository.ApplicationRepository;
import com.terpTrails.Terp.Trails.Repository.FirmRepository;
import com.terpTrails.Terp.Trails.Repository.PostingRepository;
import com.terpTrails.Terp.Trails.Repository.VolunteerRepository;

import com.terpTrails.Terp.Trails.dto.PostingRequest;
import com.terpTrails.Terp.Trails.dto.PostingWithApplicantsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostingService {

    @Autowired
    private PostingRepository postingRepository;
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private VolunteerRepository volunteerRepository;
    @Autowired
    private ApplicationRepository applicationRepository;


    public ResponseEntity<?> createPosting(PostingRequest postingRequest, String researchFirmId) {
        // Lookup the ResearchFirm object
        Optional<FirmRegistration> optionalFirm = firmRepository.findById(researchFirmId);
        if (!optionalFirm.isPresent()) {
            return ResponseEntity.badRequest().body("Invalid research firm id");
        }
        FirmRegistration researchFirm = optionalFirm.get();

        Posting posting = new Posting();
        posting.setPostTitle(postingRequest.getTitle());
        posting.setPostDescription(postingRequest.getDescription());
        posting.setPaidOrUnpaid(postingRequest.getPaidOrUnpaid());
        posting.setAgeRange(postingRequest.getAgeRange());
        posting.setAllowExtraRequirements(postingRequest.isAllowExtraRequirements());
        // If you are using @DBRef mapping, set the entire ResearchFirm object:
        posting.setResearchFirmId(researchFirmId);
        // If you chose the simpler approach storing only the firm ID, use:
        // posting.setResearchFirmId(researchFirmId);
        String postedDate= String.valueOf(LocalDateTime.now());
        posting.setPostedAt(String.valueOf(postedDate));
        posting.setStartDate(String.valueOf(postingRequest.getStartDate()));
        posting.setEndDate(String.valueOf(postingRequest.getEndDate()));

        if (postingRequest.isAllowExtraRequirements()) {
            // Call the external API to fetch extra requirements.
            try {
                // In a production application, consider configuring RestTemplate as a bean.
                RestTemplate restTemplate = new RestTemplate();
                // Replace with the actual external URL
                String externalUrl = "http://externalapi.com/requirements";

                // Assuming the external API returns a JSON array of strings;
                // For simplicity, let Spring convert it to a List.
                List<String> extraRequirements = restTemplate.getForObject(externalUrl, List.class);

                // Set the requirements from the external API.
                posting.setRequirements(extraRequirements);
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Failed to fetch extra requirements from external API: " + e.getMessage());
            }
        } else {
            // If extra requirements are not allowed, then the client should not have provided any.
            if (postingRequest.getRequirements() != null && !postingRequest.getRequirements().isEmpty()) {
                return ResponseEntity.badRequest().body("Extra requirements are not allowed.");
            }
            posting.setRequirements(null);
        }

        // Persist the new volunteer record
        Posting savedPosting = postingRepository.save(posting);
        System.out.println("Saved posting: " + savedPosting.getId());

        return ResponseEntity.ok("Post created successfully!");
    }
    public ResponseEntity<List<Posting>> getAllPosts() {
        List<Posting> posts = postingRepository.findAll();
        return ResponseEntity.ok(posts);
    }


    public ResponseEntity<List<Posting>> getPostingsForFirm(String firmId) {
        List<Posting> postings = postingRepository.findByResearchFirmId(firmId);
        return ResponseEntity.ok(postings);

    }

    public ResponseEntity<List<PostingWithApplicantsDTO>> getFirmPostingsWithApplicants(String firmId) {
        List<Posting> postings = postingRepository.findByResearchFirmId(firmId);
        List<PostingWithApplicantsDTO> result = postings.stream().map(posting -> {
            // Retrieve all applications for this posting
            List<Applications> applications = applicationRepository.findByPostingIdIn(List.of(posting.getId()));
            List<ParticipantDTO> participants = applications.stream().map(application -> {
                Optional<VolunteerRegistration> volunteerOpt = volunteerRepository.findById(application.getId());
                VolunteerRegistration volunteer = volunteerOpt.orElse(new VolunteerRegistration());
                return new ParticipantDTO(
                        volunteer.getId(),
                        volunteer.getFirstName(),
                        volunteer.getLastName(),
                        volunteer.getDateOfBirth(),  // dateOfBirth as String
                        volunteer.getEmail()
                );
            }).collect(Collectors.toList());

            PostingWithApplicantsDTO dto = new PostingWithApplicantsDTO();
            dto.setPostingid(posting.getId());
            dto.setTitle(posting.getPostTitle());
            dto.setDescription(posting.getPostDescription());
            dto.setStartDate(posting.getStartDate());
            dto.setEndDate(posting.getEndDate());
            dto.setCompensation(posting.getPaidOrUnpaid());
            dto.setParticipants(participants);
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}
