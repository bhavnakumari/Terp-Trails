package com.terpTrails.Terp.Trails.Controller;


import com.terpTrails.Terp.Trails.Entity.RecommenderResponse;
import com.terpTrails.Terp.Trails.dto.RecommendRequest;
import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/recommend")
@CrossOrigin(origins = "*")
public class RecommendController {

    @Value("${flask.api.url}")
    private String flaskApiUrl;

    @PostMapping("/diagnose")
    public ResponseEntity<RecommenderResponse> diagnose(@RequestBody RecommendRequest request) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<RecommendRequest> entity = new HttpEntity<>(request, headers);

            URI uri = UriComponentsBuilder
                    .fromHttpUrl(flaskApiUrl + "/recommend")
                    .build()
                    .toUri();

            ResponseEntity<RecommenderResponse> response = restTemplate.postForEntity(
                    uri,
                    entity,
                    RecommenderResponse.class
            );
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

}
