package com.kea.dk.demo.Model;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class WaitingList {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Boolean assigned;
    private String date;
    @OneToOne
    private Course course;
    @ManyToOne
    private Student student;


    public WaitingList(Boolean assigned, Course course, Student student, String date) {
        this.assigned = assigned;
        this.course = course;
        this.student = student;
        this.date = date;
    }

    public WaitingList() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean getAssigned() {
        return assigned;
    }

    public void setAssigned(Boolean assigned) {
        this.assigned = assigned;
    }


    public String getcurrentdate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd-yyyy");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        return dateFormat.format(cal.getTime());
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {


        this.date = date;
    }

    @Override
    public String toString() {
        return "WaitingList{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", date='" + date + '\'' +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
