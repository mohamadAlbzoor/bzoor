package com.example.bzoor.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getALlTopics(){
        return topicService.getAllTopics();
    }

    @PostMapping("/topics")
    public void addTopic(@Valid @RequestBody Topic topic){
        this.topicService.addTopic(topic);
    }
}
