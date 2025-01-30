package com.chetan.College_Admission_Portal.controller;

import com.chetan.College_Admission_Portal.entity.Students;
import com.chetan.College_Admission_Portal.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Students students) {
        studentsService.saveStudents(students);
        return new ResponseEntity<>("Student Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
        return new ResponseEntity<>(studentsService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Students> getStudentById(@PathVariable("studentId") Long studentId) {
        Students student = studentsService.getStudentsById(studentId);
        if(student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long studentId) {
        studentsService.deleteStudentsById(studentId);
        return new ResponseEntity<>("Student deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<String> updateStudentById(@PathVariable Long studentId, @RequestBody Students student) {
        studentsService.updateStudentById(studentId, student);
        return new ResponseEntity<>("Student Updated Successfully", HttpStatus.OK);
    }
}
