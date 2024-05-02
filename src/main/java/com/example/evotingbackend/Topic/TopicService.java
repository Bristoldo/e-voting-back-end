package com.example.evotingbackend.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "name1", "description1"),
            new Topic("2", "name2", "description2"),
            new Topic("3", "name3", "description3")));


    public ResponseEntity<?> getTopics() {
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    public ResponseEntity<?> getTopic(String id) {
        Topic topic = topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    public ResponseEntity<?> addTopic(Topic topic) {
        topics.add(topic);
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    public ResponseEntity<?> updateTopic(String id, Topic updatedTopic) {
        Topic topic = topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        topic.setName(updatedTopic.getName());
        topic.setDescription(updatedTopic.getDescription());
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    public ResponseEntity<?> deleTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

}
