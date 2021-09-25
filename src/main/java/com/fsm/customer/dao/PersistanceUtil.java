package com.fsm.customer.dao;

import com.fsm.customer.model.Persistent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Repository
public abstract class PersistanceUtil {

    @Autowired
    protected EntityManager em;

    public <T> void save(T t){
        em.persist(t);
    }

    public <T extends Persistent> T findBy(T t){
        return  null;
    }

    public <T> void merge(T t){
        em.merge(t);
    }
}
