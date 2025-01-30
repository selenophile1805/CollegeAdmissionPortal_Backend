package com.chetan.College_Admission_Portal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class Courses {

    @Id
    private Long courseId;
    private String courseName;
    private List<Students> courseStudents = new ArrayList<>();
    private String courseDepartment;
}
