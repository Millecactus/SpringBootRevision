package com.TomcatWhereAreU.demo.Repository.impl;

import com.TomcatWhereAreU.demo.Repository.StudentRepository;
import com.TomcatWhereAreU.demo.entity.Students;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class StudentRepositoryImpl  {

    private final List<Students> STUDENTS = new ArrayList<>();

    private final List<Students> STUDENTS2 = new ArrayList<>();
    public List<Students> findAll() {
       return STUDENTS;
    }


    public Students findById(Integer id) {
        return STUDENTS.stream()
                .filter( students -> STUDENTS.get(id).getId().equals(students.getId()))
                .findFirst()
                .orElse(null);
    }

    public List<Students> ajouter() {
       STUDENTS2.add(new Students(
               1,
               "gui",
               "gui",
               "gui"
       ));
        return STUDENTS2;
    }

    public Students save(Students students) {
        STUDENTS.add(students);
        return students;
    }

    public Students findByEmail(String email) {
    return STUDENTS.stream()
            .filter(students -> email.equals(students.getEmail()))
            .findFirst()
            .orElse(null);
    }

    public Students update(Students students){
   var studentIndex = IntStream.range(0, STUDENTS.size())
           .filter( index -> STUDENTS.get(index).getEmail().equals(students.getEmail()))
           .findFirst()
           .orElse(-1);

       if(studentIndex> -1){
           STUDENTS.set(studentIndex,students);
           return students;
       }
    return  null;
    }

    public void delete(String email) {
    var student = findByEmail(email);
        if(email != null){
            STUDENTS.remove(student);
        }
    }

}
