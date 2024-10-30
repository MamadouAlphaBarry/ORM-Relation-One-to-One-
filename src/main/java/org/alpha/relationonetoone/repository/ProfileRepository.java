package org.alpha.relationonetoone.repository;

import org.alpha.relationonetoone.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
