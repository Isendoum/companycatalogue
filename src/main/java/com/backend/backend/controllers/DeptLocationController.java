package com.backend.backend.controllers;

import com.backend.backend.repositories.DeptLocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/locations")
public class DeptLocationController {

    @Autowired
    private DeptLocationRepo deptLocationRepo;

    @GetMapping(value = "/",produces =  MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?>  allLocations() {

        try{
            return ResponseEntity.ok(deptLocationRepo.findAll());

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }

    }

}
