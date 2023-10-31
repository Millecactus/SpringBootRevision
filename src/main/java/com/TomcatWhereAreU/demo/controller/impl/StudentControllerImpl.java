package com.TomcatWhereAreU.demo.controller.impl;

import com.TomcatWhereAreU.demo.controller.StudentController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/appStudents/")
public class StudentControllerImpl implements StudentController {


    @GetMapping("hello/{name}")
    @Override
    public String sayHello(@PathVariable String name) {
        return "Bonjour" +" "+ name;
    }
}
