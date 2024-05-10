package com.example.evotingbackend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

    /**
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
