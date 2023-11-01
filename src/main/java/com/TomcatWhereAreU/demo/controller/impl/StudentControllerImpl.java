package com.TomcatWhereAreU.demo.controller.impl;

import com.TomcatWhereAreU.demo.Service.StudentService;
import com.TomcatWhereAreU.demo.Service.impl.StudentServiceImpl;
import com.TomcatWhereAreU.demo.controller.StudentController;
import com.TomcatWhereAreU.demo.entity.Students;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/students/v1")
public class StudentControllerImpl implements StudentController {

    private StudentService studentServiceImpl;

    public StudentControllerImpl(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }
    @GetMapping("/findAll")
    @Override
    public List<Students> findAll() {
        return studentServiceImpl.findAll();
    }

    @GetMapping("/hello/{name}")
    @Override
    public String sayHello(@PathVariable String name) {
        return "Bonjour" +" "+ name;
    }



    @GetMapping("/{email}")
    @Override
    public Students findByEmail(@PathVariable String email) {
        return studentServiceImpl.findByEmail(email);
    }

    @GetMapping("/ajout")
    @Override
    public List<Students> ajouter() {
        return studentServiceImpl.ajouter();
    }

    @PostMapping(value = "/save" , consumes= MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Students save(@RequestBody Students students){
        return studentServiceImpl.save(students);
    };

    @GetMapping (value = "/afficher", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public String afficherStudent(Students student) {
        return "Nom : " + student.getFirstname()
                + "Prenom : " + student.getLastname()
                + "Email : " + student.getEmail();
    }


    @PutMapping (value = "/updateStudent" , consumes= MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public Students updateStudent(@RequestBody Students students){
        return studentServiceImpl.update(students);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email){
        studentServiceImpl.delete(email);
    }
}
