package com.example.skourse.model;

public class Course {

    private String subject_id;
    private String subject_title;
    private String subject_detail;

    public Course(String subject_id, String subject_title, String subject_detail) {
        this.subject_id = subject_id;
        this.subject_title = subject_title;
        this.subject_detail = subject_detail;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public String getSubject_detail() {
        return subject_detail;
    }
}
