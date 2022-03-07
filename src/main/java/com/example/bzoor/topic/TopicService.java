package com.example.bzoor.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepo topicRepository;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        this.topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public void addTopic(Topic topic){
        this.topicRepository.save(topic);
    }
}
