/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author parlad
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "contact")
    private int contact;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private boolean status;
    
//    @OneToMany(mappedBy = "student")
//    private List<Submission> submissions;
//
//    public List<Submission> getSubmissions() {
//        return submissions;
//    }
//
//    public void setSubmissions(List<Submission> submissions) {
//        this.submissions = submissions;
//    }
//   

    public Student() {
    }

    public Student(int id, String name, int contact, String address, boolean status) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + ", status=" + status + '}';
    }

}
