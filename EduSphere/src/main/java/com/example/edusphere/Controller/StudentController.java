package com.example.edusphere.Controller;

import com.example.edusphere.Entity.Enrollment;
import com.example.edusphere.Service.EnrollmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private EnrollmentForm enrollmentService;

    @GetMapping("/Admin/Student-List")
    public String getAllStudents(Model model) {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        model.addAttribute("Enrollments", enrollments);
        return "Student-List";
    }

    @GetMapping("/Student-Form")
    public String showStudentForm() {
        return "Student-Form";
    }
}
