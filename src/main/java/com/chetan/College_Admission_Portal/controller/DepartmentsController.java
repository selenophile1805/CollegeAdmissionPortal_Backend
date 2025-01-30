package com.chetan.College_Admission_Portal.controller;

import com.chetan.College_Admission_Portal.entity.Departments;
import com.chetan.College_Admission_Portal.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody Departments department) {
        departmentsService.saveDepartment(department);
        return new ResponseEntity<>("Department added successfully.", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Departments>> getAllDepartments() {
        return new ResponseEntity<>(departmentsService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Departments> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        Departments department = departmentsService.getDepartmentById(departmentId);
        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long departmentId) {
        departmentsService.deleteDepartmentById(departmentId);
        return new ResponseEntity<>("Department deleted successfully.", HttpStatus.OK);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<String> updateDepartmentById(@PathVariable Long departmentId, @RequestBody Departments department) {
        departmentsService.updateDepartmentById(departmentId, department);
        return new ResponseEntity<>("Department updated successfully.", HttpStatus.OK);
    }
}
