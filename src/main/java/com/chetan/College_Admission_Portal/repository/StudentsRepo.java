package com.chetan.College_Admission_Portal.repository;

import com.chetan.College_Admission_Portal.entity.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentsRepo extends MongoRepository<Students, Long> {
}
