package com.example.bzoor.topic;

import com.example.bzoor.handler.deleteException;
import net.bytebuddy.implementation.bytecode.Throw;
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


    // this is 7remaat delete cause you con not delete from a table in a ManyToOne relation
    @DeleteMapping("/topics/V1/{topicId}")
    public void deleteTopicIncorrectly(@PathVariable String topicId){
        try{
            this.topicService.delete(topicId);
        }catch (Exception ex){
            throw(new deleteException(ex.getMessage(), ex));
        }
    }

    //this is the real deal
    @DeleteMapping("/topics/V2/{topicId}")
    public void deleteTopicCorrectly(@PathVariable String topicId){
        this.topicService.RealDelete(topicId);
    }
}
