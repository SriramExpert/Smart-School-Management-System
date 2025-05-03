package com.example.edusphere.Service;

import com.example.edusphere.Entity.Course;
import com.example.edusphere.Entity.Enrollment;
import com.example.edusphere.Entity.RegisterNo;
import com.example.edusphere.Repository.CourseRepository;
import com.example.edusphere.Repository.RegisterNoRepository;
import com.example.edusphere.Repository.StudentEnrollment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class EnrollmentForm {
    @Autowired
    private StudentEnrollment studentEnrollment;

    @Autowired
    private RegisterNoRepository registerNoRepository;


    public List<Enrollment> getAllEnrollments() {
        return studentEnrollment.findAll();
    }

    @Transactional
    public Enrollment save(Enrollment enrollment) {
        if (enrollment.getCourse() == null || enrollment.getCourse().getId() == null) {
            throw new IllegalArgumentException("Course not selected");
        }

        Course course = courseRepository.findById(enrollment.getCourse().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid course selected"));
        enrollment.setCourse(course);
        enrollment = studentEnrollment.save(enrollment);

        long generatedRegNo = 100000 + new Random().nextInt(900000);
        String registerNoStr = String.valueOf(generatedRegNo);
        RegisterNo registerNo = new RegisterNo(enrollment.getName(), registerNoStr, enrollment);
        registerNo = registerNoRepository.save(registerNo);
        enrollment.setRegisterNo(registerNo);

        return studentEnrollment.save(enrollment);
    }

    public Enrollment getLastEnrollment() {
        List<Enrollment> allEnrollments = studentEnrollment.findAll();
        return allEnrollments.isEmpty() ? null : allEnrollments.get(allEnrollments.size() - 1);
    }
    public Enrollment findById(Long id) {
        return studentEnrollment.findById(id).orElse(null);
    }
    public Enrollment getEnrollmentByRegisterNumber(String registerNumber) {
        return studentEnrollment.findByRegisterNo_RegisterNumber(registerNumber).orElse(null);
    }
    public Enrollment getEnrollmentById(Long id) {
        return studentEnrollment.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Long id) {
        studentEnrollment.deleteById(id);
    }

    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
}
