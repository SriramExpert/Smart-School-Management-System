package com.example.edusphere.Controller;

import com.example.edusphere.Entity.Course;
import com.example.edusphere.Entity.Enrollment;
import com.example.edusphere.Repository.CourseRepository;
import com.example.edusphere.Service.CourseService;
import com.example.edusphere.Service.EnrollmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/Student-Form/Enrollments")
public class EnrollmentController {
    @Autowired
    public EnrollmentForm enrollmentForm;
    @Autowired
    public CourseService courseService;
    @Autowired
    public CourseRepository courseRepository;

    @GetMapping("/Enrollment-form")
    public String EnrollmentFormPage(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("enrollment", new Enrollment());
        return "Enrollment-form";
    }

    @GetMapping("/add")
    public String add(Model model)
    {
        Enrollment enrollment=new Enrollment();
        model.addAttribute("enrollment", enrollment);
        return "Enrollment-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("enrollment") Enrollment enrollment) {
        enrollmentForm.save(enrollment);
        return "redirect:/Student-Form/Enrollments/student/submit";
    }

    @GetMapping("/student/submit")
    public String getLastRegisteredStudent(Model model) {
        Enrollment lastEnrollment = enrollmentForm.getLastEnrollment();
        if (lastEnrollment == null || lastEnrollment.getCourse() == null) {
            System.out.println("No student or course found.");
            return "redirect:Enrollment-form";
        }
        model.addAttribute("name", lastEnrollment.getName());
        model.addAttribute("registerNo", lastEnrollment.getRegisterNo());
        model.addAttribute("course", lastEnrollment.getCourse().getCourseName());
        model.addAttribute("mail", lastEnrollment.getMail());

        return "student-success";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Enrollment enrollment = enrollmentForm.findById(id);
        if (enrollment == null) {
            return "redirect:/Enrollment-form";
        }
        model.addAttribute("enrollment", enrollment);
        model.addAttribute("courses", courseRepository.findAll());
        System.out.println("Hi");
        return "/Enrollment-form";
    }

    @PostMapping("/edit")
    public String editEnrollment(@RequestParam("id") Long id,
                                 @RequestParam("name") String name,
                                 @RequestParam("mail") String mail,
                                 @RequestParam("course.id") Long courseId,
                                 Model model) {

        Enrollment existingEnrollment = enrollmentForm.findById(id);
        if (existingEnrollment == null) {
            return "redirect:/Enrollment-form";
        }

        existingEnrollment.setName(name);
        existingEnrollment.setMail(mail);
        Course course = courseRepository.findById(courseId).orElse(null);
        existingEnrollment.setCourse(course);

        enrollmentForm.save(existingEnrollment);
        return "redirect:/Student-Form/Enrollments/student/submit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        enrollmentForm.delete(id);
        return "redirect:/Admin/Student-List";
    }
}