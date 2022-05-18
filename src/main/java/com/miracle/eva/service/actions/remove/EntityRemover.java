package com.miracle.eva.service.actions.remove;

import com.miracle.eva.service.actions.PersistenceHolder;
import com.miracle.eva.service.actions.read.EntityReader;

import java.io.Serializable;

public abstract class EntityRemover<E, ID> extends PersistenceHolder implements Serializable {

    private final Class<E> entityClass;
    protected final EntityReader<E,ID> finder;

    protected Class<E> getEntityClass(){
        return entityClass;
    }


    public EntityRemover(Class<E> eClass, EntityReader<E,ID> finder){
        this.entityClass = eClass;
        this.finder = finder;
    }

    public void removeById(ID id){
        E e = finder.findByID(id);
        remove(e);
    }

    public void remove(E e){
        if(!getEntityManager().contains(e)){
            e = getEntityManager().merge(e);
            getEntityManager().refresh(e);
        }
        getEntityManager().remove(e);
    }


}
