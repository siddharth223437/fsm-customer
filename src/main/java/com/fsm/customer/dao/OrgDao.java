package com.fsm.customer.dao;

import com.fsm.customer.model.Organization;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

@Repository
@Transactional
public class OrgDao extends PersistanceUtil{

    public Organization findByOrgName(String orgName){
        try {
            return (Organization) em.createQuery("select o from Organization o where o.orgName= :orgName")
                    .setParameter("orgName", orgName)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }

    }
}
