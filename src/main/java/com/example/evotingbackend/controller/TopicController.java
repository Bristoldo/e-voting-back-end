package com.example.evotingbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.evotingbackend.models.Topic;
import com.example.evotingbackend.services.TopicService;

@RestController
@RequestMapping("/api/v1/auth/topics")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = {"","/"} , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTopics() {
		return topicService.getTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	} 

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateTopic(@PathVariable String id, @RequestBody Topic updatedTopic) {
		return topicService.updateTopic(id, updatedTopic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteTopic(@PathVariable String id) {
		return topicService.deleTopic(id);
	}
}
