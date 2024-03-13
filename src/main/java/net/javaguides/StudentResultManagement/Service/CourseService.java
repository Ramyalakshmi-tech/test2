package net.javaguides.StudentResultManagement.Service;


import net.javaguides.StudentResultManagement.Repository.CourseRepository;
import net.javaguides.StudentResultManagement.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));
    }
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);
        course.setName(courseDetails.getName());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    // Other methods as needed
}