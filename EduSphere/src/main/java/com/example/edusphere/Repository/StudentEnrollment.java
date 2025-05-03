package com.example.edusphere.Repository;

import com.example.edusphere.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentEnrollment extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findByRegisterNo_RegisterNumber(String registerNumber);
    Enrollment findTopByOrderByIdDesc();
}
