package com.example.evotingbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evotingbackend.topic.TopicService;

@RestController
@RequestMapping("/api/v1/auth/demo-controller")
public class demoController {

    @Autowired
    private TopicService topicService;

    @GetMapping(value = "/")
    public ResponseEntity<?> getTopics() {
        return topicService.getTopics();
    }

}
