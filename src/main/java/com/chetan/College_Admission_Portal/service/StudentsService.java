package com.chetan.College_Admission_Portal.service;

import com.chetan.College_Admission_Portal.entity.Courses;
import com.chetan.College_Admission_Portal.entity.Departments;
import com.chetan.College_Admission_Portal.entity.Students;
import com.chetan.College_Admission_Portal.repository.CoursesRepo;
import com.chetan.College_Admission_Portal.repository.DepartmentsRepo;
import com.chetan.College_Admission_Portal.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepo studentsRepo;

    @Autowired
    private CoursesRepo coursesRepo;

    @Autowired
    private DepartmentsRepo departmentsRepo;


    public void saveStudents(Students students) {
        if (students.getStudentId() == null) {
            students.setStudentId(System.currentTimeMillis());
        }
        studentsRepo.save(students);


        Courses course = coursesRepo.findByCourseName(students.getStudentCourse());
        if (course == null) {
            course = new Courses();
            course.setCourseId(System.currentTimeMillis());
            course.setCourseName(students.getStudentCourse());
            course.setCourseDepartment(students.getStudentDepartment());
        }
        course.getCourseStudents().add(students);
        Courses savedCourse = coursesRepo.save(course);


        Departments department = departmentsRepo.findByDepartmentName(students.getStudentDepartment());
        if (department == null) {
            department = new Departments();
            department.setDepartmentId(System.currentTimeMillis());
            department.setDepartmentName(students.getStudentDepartment());
        }


        department.getDepartmentStudents().add(students);


        boolean courseExists = department.getDepartmentCourses().stream()
                .anyMatch(c -> c.getCourseId().equals(savedCourse.getCourseId()));

        if (!courseExists) {
            department.getDepartmentCourses().add(savedCourse);
        }

        departmentsRepo.save(department);
    }

    public List<Students> getAllStudents() {
        return studentsRepo.findAll();
    }

    public Students getStudentsById(Long id) {
        return studentsRepo.findById(id).orElse(null);
    }

    public void deleteStudentsById(Long id) {
        Students student = studentsRepo.findById(id).orElse(null);
        if (student != null) {

            Courses course = coursesRepo.findByCourseName(student.getStudentCourse());
            if (course != null) {
                course.getCourseStudents().removeIf(s -> s.getStudentId().equals(id));
                coursesRepo.save(course);
            }



            Departments department = departmentsRepo.findByDepartmentName(student.getStudentDepartment());
            if (department != null) {
                department.getDepartmentStudents().removeIf(s -> s.getStudentId().equals(id));
                departmentsRepo.save(department);
            }

            studentsRepo.deleteById(id);
        }
    }

    public void updateStudentById(Long studentId, Students student) {
        Students oldStudent = studentsRepo.findById(studentId).orElse(null);
        if (oldStudent != null) {

            String oldCourse = oldStudent.getStudentCourse();
            String oldDepartment = oldStudent.getStudentDepartment();


            oldStudent.setStudentName(student.getStudentName() != null && !student.getStudentName().isEmpty()
                    ? student.getStudentName()
                    : oldStudent.getStudentName());
            oldStudent.setStudentCourse(student.getStudentCourse() != null && !student.getStudentCourse().isEmpty()
                    ? student.getStudentCourse()
                    : oldStudent.getStudentCourse());
            oldStudent.setStudentDepartment(student.getStudentDepartment() != null && !student.getStudentDepartment().isEmpty()
                    ? student.getStudentDepartment()
                    : oldStudent.getStudentDepartment());


            studentsRepo.save(oldStudent);


            if (!oldCourse.equals(oldStudent.getStudentCourse())) {

                Courses oldCourseObj = coursesRepo.findByCourseName(oldCourse);
                if (oldCourseObj != null) {
                    oldCourseObj.getCourseStudents().removeIf(s -> s.getStudentId().equals(studentId));
                    coursesRepo.save(oldCourseObj);
                }


                Courses newCourse = coursesRepo.findByCourseName(oldStudent.getStudentCourse());
                if (newCourse == null) {
                    newCourse = new Courses();
                    newCourse.setCourseId(System.currentTimeMillis());
                    newCourse.setCourseName(oldStudent.getStudentCourse());
                    newCourse.setCourseDepartment(oldStudent.getStudentDepartment());
                }
                newCourse.getCourseStudents().add(oldStudent);
                coursesRepo.save(newCourse);
            }


            if (!oldDepartment.equals(oldStudent.getStudentDepartment())) {

                Departments oldDeptObj = departmentsRepo.findByDepartmentName(oldDepartment);
                if (oldDeptObj != null) {
                    oldDeptObj.getDepartmentStudents().removeIf(s -> s.getStudentId().equals(studentId));
                    departmentsRepo.save(oldDeptObj);
                }



                Departments newDepartment = departmentsRepo.findByDepartmentName(oldStudent.getStudentDepartment());
                if (newDepartment == null) {
                    newDepartment = new Departments();
                    newDepartment.setDepartmentId(System.currentTimeMillis());
                    newDepartment.setDepartmentName(oldStudent.getStudentDepartment());
                }
                newDepartment.getDepartmentStudents().add(oldStudent);
                departmentsRepo.save(newDepartment);
            }
        }
    }
}