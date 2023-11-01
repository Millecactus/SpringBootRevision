package com.TomcatWhereAreU.demo.Repository;

import com.TomcatWhereAreU.demo.entity.Students;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface StudentRepository  {

    List<Students> findAll();

    Students findById(Integer id);
    List<Students> ajouter();
    Students save(Students students);
    Students findByEmail(String email);

    Students update(Students students);
    void  delete(String email);


}
