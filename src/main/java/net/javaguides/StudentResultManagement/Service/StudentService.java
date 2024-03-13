package net.javaguides.StudentResultManagement.Service;

import net.javaguides.StudentResultManagement.Repository.StudentRepository;
import net.javaguides.StudentResultManagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        // Update student fields
        existingStudent.setName(student.getName());
       // existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }


    // Other methods as needed
}
