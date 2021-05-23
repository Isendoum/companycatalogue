package com.backend.backend.controllers;

import com.backend.backend.payloads.ResponseMessage;
import com.backend.backend.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping(value = "/",produces =  MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> departments( @RequestParam(name = "locId",required = false)String locId, @RequestParam(name = "locName",required = false)String locName) {

        try{
            if(locId==null && locName ==null){
                return ResponseEntity.ok().body(departmentRepo.findAll());
            }else if (locId !=null && locName==null){
                return ResponseEntity.ok(departmentRepo.findByDeptLocationLocId(Integer.parseInt(locId)));
            } else{
                return ResponseEntity.ok(departmentRepo.findByDeptLocationLocName(locName));
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Please provide a valid parameter");

        }


    }


}
