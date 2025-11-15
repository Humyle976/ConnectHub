package com.connecthub.app.services;

import com.connecthub.app.models.TopicModel;
import com.connecthub.app.repositories.RoomRepository;
import com.connecthub.app.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public ResponseEntity<Map<String, Object>> getAllTopics(){
        List<TopicModel> topics = topicRepository.findAll();
        Map<String,Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("data",topics);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

}

