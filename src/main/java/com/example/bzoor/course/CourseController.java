package com.example.bzoor.course;

import com.example.bzoor.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/topics/{topicId}/Courses")
    public List<Course> getALlCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/Courses/{id}")
    public Course getCourses(@PathVariable String id, @PathVariable String topicId){
        return this.courseService.getCourse(id, topicId);
    }

    @PostMapping("/topics/Courses/{topicId}")
    public void addCourse(@PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId, "", ""));
        this.courseService.addCourse(course);
    }
}
