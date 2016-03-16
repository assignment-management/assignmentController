/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.DAO.Impl;

import com.neupane.relationship.entity.Student;
import com.neupane.relationship.DAO.StudentDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author parlad
 */
public class StudentDAOImpl implements StudentDAO {

    EntityManagerFactory factory;
    EntityManager manager;

    public StudentDAOImpl() {
        factory = Persistence.createEntityManagerFactory("dataSource");
        manager = factory.createEntityManager();
    }

    @Override
    public List<Student> getAll() {
        Query query = manager.createQuery("SELECT s FROM Student s");
        return (List<Student>) query.getResultList();
    }

    @Override
    public int insert(Student s) {
        EntityTransaction trans = manager.getTransaction();

        if (!trans.isActive()) {
            trans.begin();
        }
        manager.persist(s);
        manager.flush();
        trans.commit();
        return s.getId();
    }

    @Override
    public Student getById(int id) {
        return (Student) manager.find(Student.class, id);
    }

}







