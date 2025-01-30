
package com.chetan.College_Admission_Portal.repository;

import com.chetan.College_Admission_Portal.entity.Departments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentsRepo extends MongoRepository<Departments, Long> {
    Departments findByDepartmentName(String departmentName);
}