package com.example.bzoor.topic;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    private String id;
    @NotBlank(message = "Topic is mandatory")
    private String topicName;
    @NotBlank(message = "description is mandatory")
    private String description;
}
