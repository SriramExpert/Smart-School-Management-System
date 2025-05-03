package com.example.edusphere.Service;

import com.example.edusphere.Entity.ResultPage;
import com.example.edusphere.Repository.ResultPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInformationService {

    @Autowired
    private ResultPageRepository resultPageRepository;

    public List<ResultPage> getResultByNameAndRegister(String name, String registerNumber) {
        return resultPageRepository.findByNameAndRegisterNo(name, registerNumber);
    }
}
