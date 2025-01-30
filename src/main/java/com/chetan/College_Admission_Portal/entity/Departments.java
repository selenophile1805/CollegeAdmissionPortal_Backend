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
public class Departments {
    @Id
    private Long departmentId;
    private String departmentName;
    private List<Students> departmentStudents = new ArrayList<>();
    private List<Courses> departmentCourses = new ArrayList<>();
}