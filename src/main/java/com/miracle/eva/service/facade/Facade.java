package com.miracle.eva.service.facade;

import com.miracle.eva.service.actions.IActions;
import com.miracle.eva.service.actions.PersistenceHolder;
import com.miracle.eva.service.actions.create.EntityCreator;
import com.miracle.eva.service.actions.read.EntityReader;
import com.miracle.eva.service.actions.remove.EntityRemover;
import com.miracle.eva.service.actions.update.EntityUpdater;
import com.miracle.eva.service.util.RangeResult;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class Facade<E, ID> extends PersistenceHolder implements IActions<E,ID> {

    public Facade(final Class<E> entityClass,
                  EntityCreator<E> creator,
                  EntityReader<E,ID> finder,
                  EntityUpdater<E, ID> updater,
                  EntityRemover<E,ID> remover){
        this.entityClass = entityClass;
        this.finder = finder;
        this.creator = creator;
        this.updater = updater;
        this.remover = remover;
    }

    protected Class<E> entityClass;

    protected final EntityCreator<E> creator;
    protected final EntityReader<E,ID> finder;
    protected final EntityUpdater<E,ID> updater;
    protected final EntityRemover<E,ID> remover;

    @Override
    public void create(E e) {
        creator.create(e);
    }

    @Override
    public void remove(E e) {
        remover.remove(e);
    }

    @Override
    public E findById(ID id) {
        return finder.findByID(id);
    }

    @Override
    public List<E> findAll() {
        return finder.findAll();
    }

    @Override
    public List<E> findAll(RangeResult rangeResult) {
        return finder.findAll(rangeResult);
    }

    @Override
    public Long count() {
        CriteriaQuery<E> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
        Root<E> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt).as(entityClass));
        Query q = getEntityManager().createQuery(cq);
        return (Long) q.getSingleResult();
    }

    @Override
    public void edit(E e, ID id) {
        updater.update(e,id);
    }
}


