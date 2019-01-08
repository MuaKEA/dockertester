package com.kea.dk.demo.Model;

import javax.persistence.*;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String courseName;
    private String courseLanguage;
    private Integer ects;
    private Integer minStudents;
    private Integer maxStudents;
    private Integer expectedNumber;
    private String preRequisites;
    private String learningOutcome;
    private String content;
    private String learningActivities;
    private String examForm;


    @OneToOne
    private Teacher teachers;

    public Course() {
    }

    public Course(String courseName, String courseLanguage, Integer ects, Integer minStudents, Integer maxStudents, Integer expectedNumber, String preRequisites, String learningOutcome, String content, String learningActivities, String examForm, Teacher teachers) {
        this.courseName = courseName;
        this.courseLanguage = courseLanguage;
        this.ects = ects;
        this.minStudents = minStudents;
        this.maxStudents = maxStudents;
        this.expectedNumber = expectedNumber;
        this.preRequisites = preRequisites;
        this.learningOutcome = learningOutcome;
        this.content = content;
        this.learningActivities = learningActivities;
        this.examForm = examForm;
        this.teachers = teachers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        this.courseLanguage = courseLanguage;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    public Integer getMinStudents() {
        return minStudents;
    }

    public void setMinStudents(Integer minStudents) {
        this.minStudents = minStudents;
    }

    public Integer getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Integer getExpectedNumber() {
        return expectedNumber;
    }

    public void setExpectedNumber(Integer expectedNumber) {
        this.expectedNumber = expectedNumber;
    }

    public String getPreRequisites() {
        return preRequisites;
    }

    public void setPreRequisites(String preRequisites) {


            if(preRequisites.contains("åøq")) {
                 System.err.print("no nix åøq");

            }

        this.preRequisites = preRequisites;
    }

    public String getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearningActivities() {
        return learningActivities;
    }

    public void setLearningActivities(String learningActivities) {
        this.learningActivities = learningActivities;
    }

    public String getExamForm() {
        return examForm;
    }

    public void setExamForm(String examForm) {
        this.examForm = examForm;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }


    @Override
    public String toString() {
        return String.format("id: %s courseName: %s courseLanguage: %s ects: %s minStudents: %s maxStudents: %s expectedNumber: %s preRequisites: %s learningOutcome: %s  content: %s learningActivitys: %s examForm: %s teachers: %s ",
                this.id, this.courseName, this.courseLanguage, this.ects, this.minStudents, this.maxStudents, this.expectedNumber, this.preRequisites, this.learningOutcome, this.content, this.learningActivities, this.examForm, this.teachers);


    }
}
