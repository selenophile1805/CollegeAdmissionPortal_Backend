package com.chetan.College_Admission_Portal.service;

import com.chetan.College_Admission_Portal.entity.Courses;
import com.chetan.College_Admission_Portal.entity.Departments;
import com.chetan.College_Admission_Portal.repository.CoursesRepo;
import com.chetan.College_Admission_Portal.repository.DepartmentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoursesService {

    @Autowired
    private CoursesRepo coursesRepo;

    @Autowired
    private DepartmentsRepo departmentsRepo;

    public void saveCourse(Courses course) {
        if (course.getCourseId() == null) {
            course.setCourseId(System.currentTimeMillis());
        }


        Courses savedCourse = coursesRepo.save(course);


        Departments department = departmentsRepo.findByDepartmentName(course.getCourseDepartment());
        if (department == null) {
            department = new Departments();
            department.setDepartmentId(System.currentTimeMillis());
            department.setDepartmentName(course.getCourseDepartment());
        }


        boolean courseExists = department.getDepartmentCourses().stream()
                .anyMatch(c -> c.getCourseId().equals(savedCourse.getCourseId()));

        if (!courseExists) {
            department.getDepartmentCourses().add(savedCourse);
            departmentsRepo.save(department);
        }
    }

    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }

    public Courses getCourseById(Long id) {
        return coursesRepo.findById(id).orElse(null);
    }

    public void deleteCourseById(Long id) {
        Courses course = coursesRepo.findById(id).orElse(null);
        if (course != null) {

            Departments department = departmentsRepo.findByDepartmentName(course.getCourseDepartment());
            if (department != null) {
                department.getDepartmentCourses().removeIf(c -> c.getCourseId().equals(id));
                departmentsRepo.save(department);
            }
            coursesRepo.deleteById(id);
        }
    }

    public void updateCourseById(Long courseId, Courses course) {
        Courses oldCourse = coursesRepo.findById(courseId).orElse(null);
        if (oldCourse != null) {
            String oldDepartment = oldCourse.getCourseDepartment();

            oldCourse.setCourseName(course.getCourseName() != null && !course.getCourseName().isEmpty()
                    ? course.getCourseName()
                    : oldCourse.getCourseName());
            oldCourse.setCourseDepartment(course.getCourseDepartment() != null && !course.getCourseDepartment().isEmpty()
                    ? course.getCourseDepartment()
                    : oldCourse.getCourseDepartment());


            Courses savedCourse = coursesRepo.save(oldCourse);


            if (!oldDepartment.equals(oldCourse.getCourseDepartment())) {

                Departments oldDeptObj = departmentsRepo.findByDepartmentName(oldDepartment);
                if (oldDeptObj != null) {
                    oldDeptObj.getDepartmentCourses().removeIf(c -> c.getCourseId().equals(courseId));
                    departmentsRepo.save(oldDeptObj);
                }


                Departments newDepartment = departmentsRepo.findByDepartmentName(oldCourse.getCourseDepartment());
                if (newDepartment == null) {
                    newDepartment = new Departments();
                    newDepartment.setDepartmentId(System.currentTimeMillis());
                    newDepartment.setDepartmentName(oldCourse.getCourseDepartment());
                }


                boolean courseExists = newDepartment.getDepartmentCourses().stream()
                        .anyMatch(c -> c.getCourseId().equals(savedCourse.getCourseId()));

                if (!courseExists) {
                    newDepartment.getDepartmentCourses().add(savedCourse);
                    departmentsRepo.save(newDepartment);
                }
            }
        }
    }
}