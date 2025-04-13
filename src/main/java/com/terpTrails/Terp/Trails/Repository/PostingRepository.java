package com.terpTrails.Terp.Trails.Repository;


import com.terpTrails.Terp.Trails.Entity.Applications;
import com.terpTrails.Terp.Trails.Entity.FirmRegistration;
import com.terpTrails.Terp.Trails.Entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PostingRepository extends MongoRepository<Posting, Long> {
    // Additional custom query methods if needed
    Optional<Posting> findById(String id);
    List<Posting> findByResearchFirmId(String firmId);

}
