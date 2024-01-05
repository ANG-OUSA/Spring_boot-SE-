// package com.lambdacode.spring.boot.crud.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.lambdacode.spring.boot.crud.entity.Courses;
// import com.lambdacode.spring.boot.crud.repository.CourseRepository;

// @Service
// public class CourseServiceImpl implements CourseService {

//     @Autowired
//     private CourseRepository courseRepository;


//     @Override
//     public List<Courses> getAllCourses() {
//         return courseRepository.findAll();
//     }

//     @Override
//     public Courses getCourse(Long id) {
//         return courseRepository.findById(id).orElse(null);
//     }

//     @Override
//     public void deleteCourse(Long id) {
//         courseRepository.findById(id).ifPresent(courseRepository::delete);
//     }

//     public CourseRepository getCourseRepository() {
//         return courseRepository;
//     }

//     public void setCourseRepository(CourseRepository courseRepository) {
//         this.courseRepository = courseRepository;
//     }

//     @Override
//     public void addCourse(Courses course) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'addCourse'");
//     }

//     @Override
//     public void updateCourse(Long id, Courses course) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'updateCourse'");
//     }
// }
package com.lambdacode.spring.boot.crud.service.impl;

import com.lambdacode.spring.boot.crud.entity.Courses;
import com.lambdacode.spring.boot.crud.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void addCourse(Courses course) {
        courseRepository.save(course);
    }

    @Override
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCourse(Long id, Courses course) {
        courseRepository.findById(id).ifPresent(existingCourse -> {
            existingCourse.setCourseTitle(course.getCourseTitle());
            existingCourse.setDescription(course.getDescription());
            // other properties...

            courseRepository.save(existingCourse);
        });
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.findById(id).ifPresent(courseRepository::delete);
    }
}
