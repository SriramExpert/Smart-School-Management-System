package com.example.edusphere.Service;

import com.example.edusphere.Entity.RegisterNo;
import com.example.edusphere.Repository.RegisterNoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private RegisterNoRepository registerNoRepository;
    public List<RegisterNo> getAllRegisterNo(){
        return registerNoRepository.findAll();
    }
}
