package com.miracle.eva.service.actions.update;

import com.miracle.eva.service.actions.PersistenceHolder;

import java.io.Serializable;

public abstract class EntityUpdater<E, ID> extends PersistenceHolder implements Serializable {

    private final Class<E> entityClass;

    public EntityUpdater(Class<E> eClass){
        this.entityClass = eClass;
    }

    protected  Class<E> getEntityClass(){
        return entityClass;
    }

    public E update(E e, ID id){
        return getEntityManager().merge(
                getEditedEntity(e,getEntityManager().find(getEntityClass(),id)));
    }

    protected abstract E getEditedEntity(E source, E target);

}
