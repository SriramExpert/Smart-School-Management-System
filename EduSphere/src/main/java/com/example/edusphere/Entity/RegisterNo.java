package com.example.edusphere.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Register Number")
public class RegisterNo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String registerNumber;
    @OneToOne(mappedBy = "registerNo",cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", unique = true)
    private Enrollment enrollment;
    public RegisterNo(String name, String registerNumber, Enrollment enrollment) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.enrollment=enrollment;
    }
}