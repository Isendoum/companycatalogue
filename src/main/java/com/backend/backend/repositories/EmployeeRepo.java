package com.backend.backend.repositories;

import com.backend.backend.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

    List<Employee> findAll();

    List<Employee> findByDepartmentDeptId(int deptId);

    List<Employee> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName,String lastName);

}
