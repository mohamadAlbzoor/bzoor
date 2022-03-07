package com.example.bzoor.course;

import com.example.bzoor.topic.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    String id;
    @NotBlank(message = "course name is mandatory")
    String courseName;
    @NotBlank(message = "course description is mandatory")
    String description;

    @ManyToOne
    @JoinColumn
    Topic topic;
}