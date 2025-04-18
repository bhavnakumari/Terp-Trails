package com.terpTrails.Terp.Trails.Controller;


import com.terpTrails.Terp.Trails.Entity.Posting;
import com.terpTrails.Terp.Trails.dto.PostingRequest;
import com.terpTrails.Terp.Trails.service.PostingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postings")
@CrossOrigin(origins = "*")
public class PostingController {

    @Autowired
    private PostingService postingService;

    @PostMapping
    public ResponseEntity<?> addPost(@RequestBody PostingRequest postingRequest,
                                     @RequestParam String researchFirmId) {
        return postingService.createPosting(postingRequest, researchFirmId);
    }

    @GetMapping
    public ResponseEntity<List<Posting>> getAllPosts() {
        return postingService.getAllPosts();
    }


    @GetMapping("/firm")
    public ResponseEntity<List<Posting>> getPostingsForFirm(@RequestParam String firmId) {
        return postingService.getPostingsForFirm(firmId);
    }



}
