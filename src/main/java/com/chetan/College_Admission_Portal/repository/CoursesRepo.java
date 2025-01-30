package com.chetan.College_Admission_Portal.repository;

import com.chetan.College_Admission_Portal.entity.Courses;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoursesRepo extends MongoRepository<Courses, Long> {
    Courses findByCourseName(String courseName);

}
