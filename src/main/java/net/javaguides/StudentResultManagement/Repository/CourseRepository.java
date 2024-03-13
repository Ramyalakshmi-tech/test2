package net.javaguides.StudentResultManagement.Repository;

import net.javaguides.StudentResultManagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

