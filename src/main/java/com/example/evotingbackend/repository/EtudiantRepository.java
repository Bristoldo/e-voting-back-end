package com.example.evotingbackend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.evotingbackend.models.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{



}
