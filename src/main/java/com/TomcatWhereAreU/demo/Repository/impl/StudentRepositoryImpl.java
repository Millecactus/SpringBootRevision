package com.TomcatWhereAreU.demo.Repository.impl;

import com.TomcatWhereAreU.demo.Repository.StudentRepository;
import com.TomcatWhereAreU.demo.entity.Students;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final List<Students> STUDENTS = new ArrayList<>();

    private final List<Students> STUDENTS2 = new ArrayList<>();
    public List<Students> findAll() {
       return STUDENTS;
    }
    public List<Students> ajouter() {
       STUDENTS2.add(new Students(
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
