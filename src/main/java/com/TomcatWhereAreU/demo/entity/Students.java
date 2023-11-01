package com.TomcatWhereAreU.demo.entity;


import jdk.jfr.Enabled;
import lombok.Builder;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Builder

public class Students {
    public Students(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;

    }

    private String firstname;
    private String lastname;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Students() {
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





}
