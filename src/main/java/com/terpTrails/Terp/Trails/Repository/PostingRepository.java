package com.terpTrails.Terp.Trails.Repository;


import com.terpTrails.Terp.Trails.Entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostingRepository extends MongoRepository<Posting, Long> {
    // Additional custom query methods if needed

}
