package com.example.demo.Repos;

import com.example.demo.Model.Teacher;
import org.springframework.data.repository.CrudRepository;


public interface TeacherRepo extends CrudRepository<Teacher, Long> {


}