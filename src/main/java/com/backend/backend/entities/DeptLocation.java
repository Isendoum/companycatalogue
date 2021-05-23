package com.backend.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Dept_Locations")
public class DeptLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Locid",length = 2)
    private Integer locId;
    @Column(name = "Locname",length = 50)
    private String locName;
}
