/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.DAO.Impl;

import com.neupane.relationship.entity.Submission;
import com.neupane.relationship.DAO.SubmissionDAO;

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
public class SubmissionDAOImpl implements SubmissionDAO {

    EntityManagerFactory factory;
    EntityManager manager;

    public SubmissionDAOImpl() {
        factory = Persistence.createEntityManagerFactory("dataSource");
        manager = factory.createEntityManager();
    }

    @Override
    public List<Submission> getAll() {
        Query query = manager.createQuery("SELECT s FROM Submission s");
        return (List<Submission>) query.getResultList();
    }

    @Override
    public int insert(Submission s) {
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
    public Submission getById(int id) {
        return (Submission) manager.find(Submission.class, id);
    }

}
