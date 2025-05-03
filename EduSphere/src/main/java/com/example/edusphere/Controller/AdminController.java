package com.example.edusphere.Controller;

import com.example.edusphere.Entity.Admin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Component
public class AdminController {

    private final String Name = "sriram";
    private final String Password = "Sriram37";

    @GetMapping("/Admin-login")
    public String RetrivedData(Model model) {
        model.addAttribute("admin", new Admin());
        return "Admin-login";
    }

    @PostMapping("/Student-List")
    public String Verification(Model model, @ModelAttribute("admin") Admin admin){
        if (Name.equals(admin.getName()) && Password.equals(admin.getPassword())) {
            model.addAttribute("message", "Verification Successful!");
            return "redirect:Admin/Student-List";
        } else {
            model.addAttribute("message", "Verification Failed. Invalid Credentials!");
            return "Admin-login";
        }
    }

    @GetMapping("/Student-List")
    public String studentListPage() {
        return "Student-List";
    }
}
