package com.backend.backend.repositories;

import com.backend.backend.entities.Department;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DepartmentRepo extends CrudRepository<Department,Integer> {

    List<Department> findAll();
    List<Department> findByDeptId(int deptId);
    List<Department> findByDeptLocationLocName(String locName);
    List<Department> findByDeptLocationLocId(int locId);
}
