package com.terpTrails.Terp.Trails.Repository;

// VolunteerRepository.java



import com.terpTrails.Terp.Trails.Entity.FirmRegistration;
import com.terpTrails.Terp.Trails.Entity.VolunteerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VolunteerRepository extends MongoRepository<VolunteerRegistration, Long> {
    Optional<VolunteerRegistration> findByUsername(String username);
    Optional<VolunteerRegistration> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<VolunteerRegistration> findById(String id);
}
