
package com.chetan.College_Admission_Portal.service;

import com.chetan.College_Admission_Portal.entity.Departments;
import com.chetan.College_Admission_Portal.repository.DepartmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentsService {

    @Autowired
    private DepartmentsRepo departmentsRepo;

    public void saveDepartment(Departments department) {
        if (department.getDepartmentId() == null) {
            department.setDepartmentId(System.currentTimeMillis());
        }
        departmentsRepo.save(department);
    }

    public List<Departments> getAllDepartments() {
        return departmentsRepo.findAll();
    }

    public Departments getDepartmentById(Long id) {
        return departmentsRepo.findById(id).orElse(null);
    }

    public void deleteDepartmentById(Long id) {
        departmentsRepo.deleteById(id);
    }

    public void updateDepartmentById(Long departmentId, Departments department) {
        Departments oldDepartment = departmentsRepo.findById(departmentId).orElse(null);
        if (oldDepartment != null) {
            oldDepartment.setDepartmentName(department.getDepartmentName() != null && !department.getDepartmentName().isEmpty()
                    ? department.getDepartmentName()
                    : oldDepartment.getDepartmentName());
            departmentsRepo.save(oldDepartment);
        }
    }
}