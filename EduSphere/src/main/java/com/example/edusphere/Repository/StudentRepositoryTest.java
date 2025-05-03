package com.example.edusphere.Repository;

import com.example.edusphere.Entity.StudentTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryTest  extends JpaRepository<StudentTest, Long> {
}
