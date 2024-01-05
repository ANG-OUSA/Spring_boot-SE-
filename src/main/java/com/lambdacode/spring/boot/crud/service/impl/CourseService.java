package com.lambdacode.spring.boot.crud.service.impl;


import com.lambdacode.spring.boot.crud.entity.Courses;
import java.util.List;

public interface CourseService {
    void addCourse(Courses course);

    List<Courses> getAllCourses();

    Courses getCourse(Long id);

    void updateCourse(Long id, Courses course);

    void deleteCourse(Long id);
}



