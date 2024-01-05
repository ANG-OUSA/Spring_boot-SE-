package com.lambdacode.spring.boot.crud.controller;

import com.lambdacode.spring.boot.crud.entity.Courses;
import com.lambdacode.spring.boot.crud.service.impl.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody Courses course) {
        courseService.addCourse(course);
        return ResponseEntity.ok("Course added successfully");
    }

    @GetMapping
    public List<Courses> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourse(@PathVariable Long id) {
        Courses course = courseService.getCourse(id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Courses course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.ok("Course updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
