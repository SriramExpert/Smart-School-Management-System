package com.example.edusphere.Controller;

import com.example.edusphere.Entity.Course;
import com.example.edusphere.Entity.RegisterNo;
import com.example.edusphere.Entity.Teacher;
import com.example.edusphere.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Component
public class TeacherController {
    @Autowired
    public TeacherService teacherService;

    private final String Name = "sriram";
    private final String Password = "Sriram37";

    @GetMapping("/Teacher-form")
    public String RetrivedData(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "Teacher-form";
    }

    @PostMapping("/Teacher-role")
    public String Verification(Model model, @ModelAttribute("teacher") Teacher teacher){

        if (Name.equals(teacher.getName()) && Password.equals(teacher.getPassword())) {
            model.addAttribute("message", "Verification Successful!");
            return "redirect:Teacher-role";
        } else {
            model.addAttribute("message", "Verification Failed. Invalid Credentials!");
            return "Teacher-form";
        }
    }

    @GetMapping("/Teacher-role")
    public String studentListPage() {
        return "Teacher-role";

    }

    @GetMapping("/Teacher-role/AddCourse")
    public String showAddCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "AddCourse";
    }

    @GetMapping("/RegisterNumber")
    public String findAllCourses(Model model) {
        List<RegisterNo> registerNo = teacherService.getAllRegisterNo();
        model.addAttribute("registerNo", registerNo);
        return "ResultUpdation";
    }
}

