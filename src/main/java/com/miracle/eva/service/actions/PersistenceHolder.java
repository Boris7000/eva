package com.miracle.eva.service.actions;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class PersistenceHolder {

    @PersistenceContext(unitName = "evadb")
    private EntityManager em;

    public EntityManager getEntityManager(){
        return em;
    }

}
