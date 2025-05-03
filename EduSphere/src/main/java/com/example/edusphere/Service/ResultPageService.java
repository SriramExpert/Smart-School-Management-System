package com.example.edusphere.Service;

import com.example.edusphere.Entity.ResultPage;
import com.example.edusphere.Repository.ResultPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultPageService {

    @Autowired
    private ResultPageRepository resultPageRepository;

    public List<ResultPage> findByNameAndRegisterNo(String name, String registerNo) {
        return resultPageRepository.findByNameAndRegisterNo(name, registerNo);
    }

    public void saveAll(List<ResultPage> resultPages) {
        for (ResultPage page : resultPages) {
            List<ResultPage> existing = resultPageRepository.findByNameAndRegisterNo(page.getName(), page.getRegisterNo());
            if (!existing.isEmpty()) {
                ResultPage oldPage = existing.get(0);
                oldPage.setExammark(page.getExammark());
                oldPage.setAttendancepercent(page.getAttendancepercent());
                oldPage.setResult(page.getResult());
                oldPage.setConfirmed(true);
                resultPageRepository.save(oldPage);
            } else {
                page.setConfirmed(true);
                resultPageRepository.save(page);
            }
        }
    }

    public ResultPage findById(int id) {
        return resultPageRepository.findById((long) id).orElse(null);
    }
    public List<ResultPage> findAllResults() {
        return resultPageRepository.findAll();
    }
    public void save(ResultPage page) {
        resultPageRepository.save(page);
    }
}
