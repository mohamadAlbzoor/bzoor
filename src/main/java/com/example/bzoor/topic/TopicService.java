package com.example.bzoor.topic;

import com.example.bzoor.course.Course;
import com.example.bzoor.course.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TopicService {

    @Autowired
    TopicRepo topicRepository;

    @Autowired
    CourseRepo courseRepo;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        this.topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public void addTopic(Topic topic){
        this.topicRepository.save(topic);
    }

    public void delete(String id){
        this.topicRepository.deleteById(id);
    }

    public void RealDelete(String id){
//        List<Course> courses = new ArrayList<>();
//        this.courseRepo.findByTopicId(id).forEach(courses::add);

        this.courseRepo.findByTopicId(id).forEach(c -> courseRepo.delete(c));
        this.topicRepository.deleteById(id);
    }
}
