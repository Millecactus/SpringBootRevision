package com.TomcatWhereAreU.demo.entity.dto;

import com.TomcatWhereAreU.demo.Repository.StudentRepository;
import com.TomcatWhereAreU.demo.entity.Students;
import lombok.Builder;

@Builder

public class StudentDTO {

    private String firstname;
    private String lastname;
    private String email;

    public StudentDTO(String firstname, String lastname, String email) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
    }

    public StudentDTO() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public StudentDTO fromEntity(Students students){

        return  StudentDTO.builder()
                .firstname(students.getFirstname())
                .lastname(students.getLastname())
                .email(students.getEmail())
                .build();
    }

    public Students toEntity(StudentDTO studentDTO){
        return Students.builder()
                .firstname(studentDTO.getFirstname())
                .lastname(studentDTO.getLastname())
                .email(studentDTO.getEmail())
                .build();
    }

}
