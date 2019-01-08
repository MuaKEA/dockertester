package com.kea.dk.demo.Repos;


import com.kea.dk.demo.Model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();


}
