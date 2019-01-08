package com.kea.dk.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher extends Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String address;
    private int postcode;
    private String city;
    private String email;
    private Long tlf;

    public Teacher(String firstName, String lastName, String address, int postcode, String city, String email, Long tlf) {
        super(firstName, lastName);
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.email = email;
        this.tlf = tlf;
    }

    public Teacher() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTlf() {
        return tlf;
    }

    public void setTlf(Long tlf) {
        this.tlf = tlf;
    }


}
