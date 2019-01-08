package com.kea.dk.demo.Repos;


import com.kea.dk.demo.Model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<Teacher, Long> {


}