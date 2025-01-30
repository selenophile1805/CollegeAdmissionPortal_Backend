package com.chetan.College_Admission_Portal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Students {
    @Id
    private Long studentId;
    private String studentName;
    private String studentCourse;
    private String studentDepartment;
}