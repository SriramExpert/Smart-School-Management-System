package com.example.edusphere.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Result_Table")
public class ResultPage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;
    public String registerNo;
    public String name;
    public String Exammark;
    public String Attendancepercent;
    public String result;
    private boolean confirmed;

    public ResultPage(String name,String registerNo,String Exammark, String Attendancepercent,String result){
        this.name=name;
        this.registerNo=registerNo;
        this.Exammark=Exammark;
        this.Attendancepercent=Attendancepercent;
        this.result=result;
    }
}
