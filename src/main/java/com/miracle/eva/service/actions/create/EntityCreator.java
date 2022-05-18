package com.miracle.eva.service.actions.create;

import com.miracle.eva.service.actions.PersistenceHolder;

import java.io.Serializable;

public abstract class EntityCreator<E> extends PersistenceHolder implements Serializable {

    public abstract Class<E> getEntityClass();

    public E create(E e){
        getEntityManager().persist(e);
        return e;
    }
}
