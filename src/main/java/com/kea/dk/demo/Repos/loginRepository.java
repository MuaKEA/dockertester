package com.kea.dk.demo.Repos;


import com.kea.dk.demo.Model.LoginTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface loginRepository extends CrudRepository<LoginTable, Long> {


    List<LoginTable> findAll();

    List<LoginTable> findByPassword(String password);

    LoginTable findByEmail(String email);
}

