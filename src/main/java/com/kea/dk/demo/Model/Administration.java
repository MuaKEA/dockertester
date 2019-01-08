package com.kea.dk.demo.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Administration extends Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String Email;


    public Administration(String firstName, String lastName, String Email) {
        super(firstName, lastName);
        this.Email = Email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}



