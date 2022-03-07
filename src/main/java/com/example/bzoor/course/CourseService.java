package com.example.bzoor.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        this.courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id, String topicID){
        return this.courseRepository.findByIdAndTopicId(id, topicID);
    }

    public void addCourse(Course course){
        this.courseRepository.save(course);
    }

}
