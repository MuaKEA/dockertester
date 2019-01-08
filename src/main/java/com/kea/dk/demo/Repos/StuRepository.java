package com.kea.dk.demo.Repos;


import com.kea.dk.demo.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StuRepository extends CrudRepository<Student, Long> {

    Student findByEmail(String email);

    Student findStudentById(Long id);
}

