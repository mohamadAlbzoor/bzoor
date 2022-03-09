package com.example.bzoor.course;

import com.example.bzoor.topic.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CourseServiceTest {

    @InjectMocks
    CourseService courseService;

    @Mock
    CourseRepo courseRepo;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("testing get all courses")
    void getCourseTest() {

        Topic topic = new Topic("tId", "topicName", "topicDescription");
        List <Course> course = Arrays.asList(
                new Course("id1", "courseName1", "courseDescription1", topic),
                new Course("id2", "courseName2", "courseDescription2", topic),
                new Course("id3", "courseName3", "courseDescription3", topic)
        );
        when(this.courseRepo.findByTopicId(anyString())).thenReturn(course);
        List<Course> res = this.courseService.getAllCourses("anId");

        //this line is for me only
        System.out.println("this is what i expect : "+course.get(1).id+ " this is what i got : " + res.get(1).id);
        assertEquals(course,res,"the get should work successfully");
    }
}