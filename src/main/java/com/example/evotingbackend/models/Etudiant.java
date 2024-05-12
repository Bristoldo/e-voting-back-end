package com.example.evotingbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(builderMethodName = "etudiantBuilder")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etudiants")
public class Etudiant extends User {

    private Integer niveau;
    private String filiere;
 
}
