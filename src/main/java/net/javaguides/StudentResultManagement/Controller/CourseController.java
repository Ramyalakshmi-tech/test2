package net.javaguides.StudentResultManagement.Controller;


import net.javaguides.StudentResultManagement.Service.CourseService;
import net.javaguides.StudentResultManagement.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        return ResponseEntity.ok(updatedCourse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
