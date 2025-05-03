package com.example.edusphere.Controller;

import com.example.edusphere.Entity.*;
import com.example.edusphere.Repository.StudentEnrollment;
import com.example.edusphere.Service.ResultPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/Result")
public class ResultPageController {

    @Autowired
    public StudentEnrollment studentEnrollment;
    @Autowired
    public ResultPageService resultPageService;

    @GetMapping("/load")
    public String loadForm(Model model) {
        List<ResultPage> resultPages = resultPageService.findAllResults();
        List<Enrollment> students = studentEnrollment.findAll();

        List<String> existingRegisterNumbers = resultPages.stream()
                .map(ResultPage::getRegisterNo)
                .toList();

        List<ResultPage> newResultPages = students.stream()
                .filter(student -> !existingRegisterNumbers.contains(student.getRegisterNo().getRegisterNumber()))
                .map(student -> {
                    ResultPage rp = new ResultPage(
                            student.getName(),
                            student.getRegisterNo().getRegisterNumber(),
                            null,
                            null,
                            ""
                    );
                    rp.setConfirmed(false);
                    return rp;
                }).toList();
        resultPages.addAll(newResultPages);
        ResultPageWrapper wrapper = new ResultPageWrapper();
        wrapper.setResultPageList(resultPages);
        model.addAttribute("resultWrapper", wrapper);
        return "/ResultUpdation";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ResultPageWrapper resultWrapper) {
        List<ResultPage> resultPages = resultWrapper.getResultPageList();

        if (resultPages != null && !resultPages.isEmpty()) {
            resultPageService.saveAll(resultPages);
        } else {
            System.out.println("Received null or empty result list!");
        }

        return "redirect:/Result/load";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        ResultPage resultPage = resultPageService.findById(Math.toIntExact(id));
        if (resultPage == null) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        model.addAttribute("resultPage", resultPage);
        return "/ResultEditForm";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute ResultPage resultPage) {
        ResultPage existingStudent = resultPageService.findById(resultPage.getId());
        if (existingStudent == null) {
            throw new RuntimeException("Student not found with id: " + resultPage.getId());
        }

        existingStudent.setExammark(resultPage.getExammark());
        existingStudent.setAttendancepercent(resultPage.getAttendancepercent());
        existingStudent.setResult(resultPage.getResult());

        resultPageService.save(existingStudent);

        return "redirect:/Result/load";
    }


}


