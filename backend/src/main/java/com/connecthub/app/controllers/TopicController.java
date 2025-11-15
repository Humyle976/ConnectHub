package com.connecthub.app.controllers;

import com.connecthub.app.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/topics")
    public ResponseEntity<Map<String,Object>> getAllTopics() {
        return topicService.getAllTopics();
    }
}
