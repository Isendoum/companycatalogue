package com.backend.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Empid",nullable = false,length = 4)
    private int empId;
    @Column(name = "Lastname",length = 20)
    private String lastName;
    @Column(name = "Firstname",length = 15)
    private String firstName;
    @Column(name = "Job",length = 9)
    private String job;
    @ManyToOne
    @JoinColumn(name = "MNGID")
    private Employee manager;
    @Column(name = "Hiredate")
    private Date hireDate;
    @Column(name = "Salary",precision=7, scale=2)
    private Float salary;
    @Column(name = "Comm",precision=7, scale=2)
    private Float comm;
    @ManyToOne
    @JoinColumn(name = "Deptid")
    private Department department;

    public String getDepartment(){
        if(department!=null) {
            return department.getDName();
        } else return "";

    }


    public String getManager(){
        if(manager!=null){
            return manager.getLastName()+" "+manager.getFirstName();
        }else return "";

    }



}
