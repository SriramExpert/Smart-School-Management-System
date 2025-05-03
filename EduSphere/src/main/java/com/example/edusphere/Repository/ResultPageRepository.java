package com.example.edusphere.Repository;

import com.example.edusphere.Entity.ResultPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultPageRepository extends JpaRepository<ResultPage,Long> {
    List<ResultPage> findByNameAndRegisterNo(String name, String registerNo);

}

