package com.TomcatWhereAreU.demo.controller;


import com.TomcatWhereAreU.demo.entity.Students;

import java.util.List;

public interface StudentController {

    String sayHello(String name);

    List<Students> findAll();

    Students findByEmail(String email);

    List<Students> ajouter();

    String afficherStudent(Students student);
}
