package com.example.evotingbackend.topic;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description; 
}
