/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "facilitator")
public class Facilitator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "contect")
    private int contect;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "fal")
    private List<Relation> relations;

    public Facilitator() {
    }

    public Facilitator(int id, String name, int contect, String address, boolean status) {
        this.id = id;
        this.name = name;
        this.contect = contect;
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

    public int getContect() {
        return contect;
    }

    public void setContect(int contect) {
        this.contect = contect;
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

}
