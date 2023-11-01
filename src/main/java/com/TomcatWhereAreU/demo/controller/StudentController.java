package com.TomcatWhereAreU.demo.controller;


import com.TomcatWhereAreU.demo.entity.Students;

import java.util.List;

public interface StudentController {

    String sayHello(String name);

    List<Students> findAll();

    Students findById(Integer id);

    List<Students> ajouter();

    String afficherStudent(Students student);
}
