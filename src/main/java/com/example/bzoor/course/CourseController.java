package com.example.bzoor.course;

import com.example.bzoor.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/topics/Courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        this.courseService.deleteCourse(courseId);
    }

    @PutMapping("/topics/Courses")
    public void update(@RequestBody Course course){
        this.courseService.put(course);
    }

    @PatchMapping("/topics/Courses/{courseId}")
    public void UpdateDescription(@PathVariable String courseId, @RequestBody Map<String, Object> courseDescription){
        this.courseService.patch(courseId, courseDescription.get("description").toString());
    }
}
