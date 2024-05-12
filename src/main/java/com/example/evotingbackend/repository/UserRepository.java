package com.example.evotingbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.evotingbackend.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    /**
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
