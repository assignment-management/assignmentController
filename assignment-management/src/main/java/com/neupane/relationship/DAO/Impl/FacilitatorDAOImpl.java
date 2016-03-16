/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.DAO.Impl;

import com.neupane.relationship.entity.Facilitator;
import com.neupane.relationship.DAO.FacilitatorDAO;
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
public class FacilitatorDAOImpl implements FacilitatorDAO {

    EntityManagerFactory factory;
    EntityManager manager;

    public FacilitatorDAOImpl() {
        factory = Persistence.createEntityManagerFactory("dataSource");
        manager = factory.createEntityManager();
    }

    @Override
    public List<Facilitator> getAll() {
        Query query = manager.createQuery("SELECT f FROM Facilitator f");
        return (List<Facilitator>) query.getResultList();
    }

    @Override
    public int insert(Facilitator f) {
        EntityTransaction trans = manager.getTransaction();

        if (!trans.isActive()) {
            trans.begin();
        }
        manager.persist(f);
        manager.flush();
        trans.commit();
        return f.getId();
    }

    @Override
    public Facilitator getById(int id) {
        return (Facilitator) manager.find(Facilitator.class, id);
    }

}
