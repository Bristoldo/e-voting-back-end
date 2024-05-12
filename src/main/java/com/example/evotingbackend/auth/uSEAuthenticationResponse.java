package com.example.evotingbackend.auth;

import com.example.evotingbackend.models.Etudiant;
import com.example.evotingbackend.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class uSEAuthenticationResponse {
    private String token;

    private String firstname;

    private String lastname;

    private Integer niveau;
    
    private String filiere;

    private Role role;

}
