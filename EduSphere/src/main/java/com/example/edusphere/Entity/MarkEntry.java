package com.example.edusphere.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MarkTest")
public class MarkEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String registerNumber;
    public int attendanceMark;
    public int marks;
    public MarkEntry(String name, String registerNumber, int attendanceMark, int marks)
    {
        this.name=name;
        this.registerNumber=registerNumber;
        this.attendanceMark=attendanceMark;
        this.marks=marks;
    }
}