package com.example.edusphere.Controller;

import com.example.edusphere.Entity.ResultPage;
import com.example.edusphere.Service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @GetMapping("/check/userId")
    public String checkUserId(@RequestParam String name, @RequestParam String registerNumber, Model model) {
        List<ResultPage> results = personalInformationService.getResultByNameAndRegister(name, registerNumber);
        if (!results.isEmpty()) {
            model.addAttribute("results", results);
            return "showResult"; // Loop over results in your Thymeleaf
        }
        model.addAttribute("error", "No result found for the given details.");
        return "errorPage";
    }

    @GetMapping("/Student-Form/student-verification")
    public String showForm() {
        return "student-verification";
    }

}
