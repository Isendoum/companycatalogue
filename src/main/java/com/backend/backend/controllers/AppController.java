package com.backend.backend.controllers;

import com.backend.backend.entities.Employee;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class AppController {

    @GetMapping(value = "/")
    public String app() {

        return "index.html";
    }
}
