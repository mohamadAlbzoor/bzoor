package com.example.bzoor.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepo extends CrudRepository<Course, String> {
    public List<Course> findByTopicId(String topicId);
    public Course findByIdAndTopicId(String id, String topicId);
}