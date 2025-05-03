package com.example.edusphere.Service;

import com.example.edusphere.Entity.Course;
import com.example.edusphere.Repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseService implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    @Transactional
    public Course savedCourse(Course course)
    {
        return courseRepository.save(course);
    }

    @Override
    public void run(String... args) throws Exception {
        if (courseRepository.count() == 0) {
            List<Course> defaultCourses = Arrays.asList(
                    new Course("101", "Mathematics"),
                    new Course("102", "Science"),
                    new Course("103", "History"),
                    new Course("104", "English")
            );
            courseRepository.saveAll(defaultCourses);
            System.out.println("Default courses added to the database.");
        } else {
            System.out.println("Courses already exist, skipping initialization.");
        }
    }
}
