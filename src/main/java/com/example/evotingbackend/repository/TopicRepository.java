package com.example.evotingbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.evotingbackend.models.Topic;


public interface TopicRepository extends CrudRepository<Topic, String>{
    

}