package com.TomcatWhereAreU.demo.Service;

import com.TomcatWhereAreU.demo.entity.Students;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    List<Students> findAll();
    List<Students> ajouter();

    Students save(Students students);

    Students findByEmail(String email);

    Students findById(Integer id);

    Students update(Students students);


    void  delete(String email);

}

