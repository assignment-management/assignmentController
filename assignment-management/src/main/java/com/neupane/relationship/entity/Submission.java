/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author parlad
 */
@Entity
@Table(name = "submission")
public class Submission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "submitted_by")
    private String submittedBy;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "marks")
    private int marks;
    
    @Column(name = "submission_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    
    
//    @ManyToOne
//    private Student student;
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public Submission() {
    }

    public Submission(int id, String submittedBy, String content, int marks) {
        this.id = id;
        this.submittedBy = submittedBy;
        this.content = content;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

}
