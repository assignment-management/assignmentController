/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.DAO.Impl;

import com.neupane.relationship.entity.Relation;
import com.neupane.relationship.DAO.RelationshipDAO;
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
public class RelationDAOImpl implements RelationshipDAO {

    EntityManagerFactory factory;
    EntityManager manager;

    public RelationDAOImpl() {
        factory = Persistence.createEntityManagerFactory("dataSource");
        manager = factory.createEntityManager();
    }

    @Override
    public List<Relation> getAll() {
        Query query = manager.createQuery("SELECT r FROM Relation r");
        return (List<Relation>) query.getResultList();
    }

    @Override
    public int insert(Relation r) {
        EntityTransaction trans = manager.getTransaction();

        if (!trans.isActive()) {
            trans.begin();
        }
        manager.persist(r);
        manager.flush();
        trans.commit();
        return r.getId();
    }

    @Override
    public Relation getById(int id) {
        return (Relation) manager.find(Relation.class, id);
    }

}
