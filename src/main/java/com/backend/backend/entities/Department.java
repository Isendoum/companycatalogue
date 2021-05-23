package com.backend.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Deptid",length = 2)
    private Integer deptId;
    @Column(name = "Dname",length = 14)
    private String dName;
    @ManyToOne
    @JoinColumn(name = "Locid")
    private DeptLocation deptLocation;

    public String getDeptLocation(){
        if(deptLocation!=null){
            return  deptLocation.getLocName();
        } else return "";
    }

}
