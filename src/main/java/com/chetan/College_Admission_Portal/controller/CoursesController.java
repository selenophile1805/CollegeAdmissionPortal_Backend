package com.chetan.College_Admission_Portal.controller;

import com.chetan.College_Admission_Portal.entity.Courses;
import com.chetan.College_Admission_Portal.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Courses course) {
        coursesService.saveCourse(course);
        return new ResponseEntity<>("Course added successfully.", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Courses>> getAllCourses() {
        return new ResponseEntity<>(coursesService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Courses> getCourseById(@PathVariable("courseId") Long courseId) {
        Courses course = coursesService.getCourseById(courseId);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long courseId) {
        coursesService.deleteCourseById(courseId);
        return new ResponseEntity<>("Course deleted successfully.", HttpStatus.OK);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<String> updateCourseById(@PathVariable Long courseId, @RequestBody Courses course) {
        coursesService.updateCourseById(courseId, course);
        return new ResponseEntity<>("Course updated successfully.", HttpStatus.OK);
    }
}
