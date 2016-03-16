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
@Table(name = "relation")
public class Relation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "facilitatorId")
    private int faciliatatorId;
    @Column(name = "assignmentId")
    private int assignmentId;
    @Column(name = "added_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "submission_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date submissionDate;
    
    @ManyToOne
    private Facilitator fal;

    public Relation() {
    }

    public Relation(int id, int faciliatatorId, int assignmentId) {
        this.id = id;
        this.faciliatatorId = faciliatatorId;
        this.assignmentId = assignmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFaciliatatorId() {
        return faciliatatorId;
    }

    public void setFaciliatatorId(int faciliatatorId) {
        this.faciliatatorId = faciliatatorId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

}
