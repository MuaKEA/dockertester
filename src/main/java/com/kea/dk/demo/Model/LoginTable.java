package com.kea.dk.demo.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginTable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String email;
    private String password;
    private int Niveau;

    public LoginTable(String email, String password, int Niveau) {
        this.email = email;
        this.password = password;
        this.Niveau = Niveau;
    }

    public LoginTable() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNiveau() {
        return Niveau;
    }


    public void setNiveau(int niveau) {
        Niveau = niveau;
    }

    @Override
    public String toString() {
        return "LoginTable{" + "id=" + id + ", email='" + email + '\'' + ", password='" + password + '\'' + ", Niveau=" + Niveau +
                '}';
    }
}
