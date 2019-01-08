package com.kea.dk.demo.Repos;

import com.example.demo.Model.WaitingList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WaitinglistRepo extends CrudRepository<WaitingList, Long> {
    List<WaitingList> findAll();

    WaitingList findByStudentIdAndCourseId(Long id, Long id2);

    List<WaitingList> findByAssigned(Boolean assigned);

    Iterable<WaitingList> findAllByStudentId(Long id);

    WaitingList deleteByStudentIdAndCourseId(Long id, Long id2);

    List<WaitingList> findByStudentIdAndAssigned(Long id, Boolean b);


}
