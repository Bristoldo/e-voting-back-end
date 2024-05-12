package com.example.evotingbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.evotingbackend.models.Topic;
import com.example.evotingbackend.repository.TopicRepository;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public ResponseEntity<?> getTopics() {
        return new ResponseEntity<>(topicRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getTopic(String id) {
        return new ResponseEntity<>(topicRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<?> addTopic(Topic topic) {
        topicRepository.save(topic);
        return new ResponseEntity<>(topicRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> updateTopic(String id, Topic updatedTopic) {
        topicRepository.save(updatedTopic);
        return new ResponseEntity<>(topicRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleTopic(String id) {
        topicRepository.deleteById(id);
        return new ResponseEntity<>(topicRepository.findAll(), HttpStatus.OK);
    }

}
