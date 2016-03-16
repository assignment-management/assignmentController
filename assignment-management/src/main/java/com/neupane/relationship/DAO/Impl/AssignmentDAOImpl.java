/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.DAO.Impl;

import com.neupane.relationship.entity.Assignments;
import com.neupane.relationship.DAO.AssignmentDAO;
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
public class AssignmentDAOImpl implements AssignmentDAO{

    EntityManagerFactory factory;
    EntityManager manager;

    public AssignmentDAOImpl(){
        factory = Persistence.createEntityManagerFactory("dataSource");
        manager = factory.createEntityManager();
    }

    @Override
    public List<Assignments> getAll() {
        Query query = manager.createQuery("SELECT a FROM Assignments a");
        return (List<Assignments>) query.getResultList();
    }

    @Override
    public int insert(Assignments a) {
        EntityTransaction trans = manager.getTransaction();

        if (!trans.isActive()) {
            trans.begin();
        }
        manager.persist(a);
        manager.flush();
        trans.commit();
        return a.getId();
    }

    @Override
    public Assignments getById(int id) {
        return (Assignments) manager.find(Assignments.class, id);
    }

}
