package com.TomcatWhereAreU.demo.Service.impl;
;
import com.TomcatWhereAreU.demo.Repository.impl.StudentRepositoryImpl;
import com.TomcatWhereAreU.demo.Service.StudentService;
import com.TomcatWhereAreU.demo.entity.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("studentServiceImpl")
@Service
public class StudentServiceImpl implements StudentService {
    public StudentServiceImpl(StudentRepositoryImpl studentRepository) {
        this.studentRepository = studentRepository;
    }
    private final StudentRepositoryImpl studentRepository;

    @Override
    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Students> ajouter() {
        return studentRepository.ajouter();
    }
    @Override
    public Students save(Students students) {
        return  this.studentRepository.save(students);
    }

    @Override
    public Students findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Students findById(Integer id) {
        return studentRepository.findById(id);
    }


    @Override
    public Students update(Students students) {
        return studentRepository.update(students);
    }
    @Override
    public void delete(String email) {
        studentRepository.delete(email);
    }

}
