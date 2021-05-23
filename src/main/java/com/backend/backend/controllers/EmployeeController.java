package com.backend.backend.controllers;

import com.backend.backend.entities.Employee;
import com.backend.backend.payloads.ResponseMessage;
import com.backend.backend.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_XML_VALUE)
    public List<Employee> employeeListList() {

        return employeeRepo.findAll();
    }

    @GetMapping(value = "/employeesByDept/",produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> employeesByDept(@RequestParam(name = "deptId") int deptId) {

        if(employeeRepo.findByDepartmentDeptId(deptId).size()==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("No employees found for department id: "+deptId));
        }else {

            return ResponseEntity.ok(employeeRepo.findByDepartmentDeptId(deptId));
        }

    }

    @GetMapping(value = "/employee/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> employeeById(@RequestParam(name = "empId") int empId) {

        try{
            Optional<Employee> employee = employeeRepo.findById(empId);
            return ResponseEntity.ok(employee.get());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("No employee found for id:" +empId));
        }

    }
    @GetMapping(value = "/search/", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> employeeSearch(@RequestParam(name = "lastName",required = false) String lastName,@RequestParam(name = "firstName",required =false) String firstName) {
        if(lastName!=null && firstName!=null){

            if(lastName.equals("") && firstName.equals("")){
                return ResponseEntity.ok(employeeRepo.findAll());
            }else{
                return ResponseEntity.ok().body(employeeRepo.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(firstName, lastName));
            }

        }else return ResponseEntity.ok(employeeRepo.findAll());

    }

}
