package org.alpha.relationonetoone.repository;

import org.alpha.relationonetoone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   @Query("SELECT u FROM User u LEFT JOIN FETCH u.profile WHERE u.id=:userId")
    Optional<User> findUserWithProfile(@Param("userId") Long userId);
}
