package com.terpTrails.Terp.Trails.Repository;

import com.terpTrails.Terp.Trails.Entity.Applications;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Applications, String> {
    // Retrieve all applications for a given posting ID
    List<Applications> findByPostingId(String postingId);
}
