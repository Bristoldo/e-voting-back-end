package com.example.evotingbackend.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.evotingbackend.config.JwtService;
import com.example.evotingbackend.models.Etudiant;
import com.example.evotingbackend.models.Role;
import com.example.evotingbackend.repository.EtudiantRepository;
import com.example.evotingbackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

        private final UserRepository userRepository;

        private final EtudiantRepository etudiantRepository;

        private final PasswordEncoder passwordEncoder;

        private final JwtService jwtService;

        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {

                var etudiant = Etudiant.etudiantBuilder()
                                .build();

                etudiant.setFirstname(request.getFirstname());
                etudiant.setLastname(request.getLastname());
                etudiant.setEmail(request.getEmail());
                etudiant.setPassword(passwordEncoder.encode(request.getPassword()));
                etudiant.setRole(Role.USER);
                etudiant.setNiveau(1);
                etudiant.setFiliere("informatique");

                etudiantRepository.save(etudiant);

                var jwtToken = jwtService.generateToken(etudiant);

                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .firstname(etudiant.getFirstname())
                                .lastname(etudiant.getLastname())
                                .role(etudiant.getRole())
                                .niveau(1)
                                .filiere("informatique")
                                .build();
        }

        // @SuppressWarnings({ "static-access", "null" })
        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow();

                var etudiant = etudiantRepository.findById(user.getId()).get();

                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .firstname(etudiant.getFirstname())
                                .lastname(etudiant.getLastname())
                                .role(etudiant.getRole())
                                .niveau(etudiant.getNiveau())
                                .filiere(etudiant.getFiliere())
                                .build();
        }

        public Boolean logout(HttpSecurity http) {
                return true;
        }

}
