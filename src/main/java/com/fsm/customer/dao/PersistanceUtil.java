package com.fsm.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Transactional
@Repository
public abstract class PersistanceUtil {

    @Autowired
    private EntityManager em;

    public <T> void save(T t){
        em.persist(t);
    }
}
