package com.terpTrails.Terp.Trails.Repository;

import com.terpTrails.Terp.Trails.Entity.FirmRegistration;
import com.terpTrails.Terp.Trails.dto.FirmRegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FirmRepository extends MongoRepository<FirmRegistration, Long> {
    Optional<FirmRegistration> findByUsername(String username);
    Optional<FirmRegistration> findByEmail(String email);
    Optional<FirmRegistration> findById(String id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
