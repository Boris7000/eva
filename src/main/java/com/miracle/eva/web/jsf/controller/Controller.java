package com.miracle.eva.web.jsf.controller;

import com.miracle.eva.service.facade.Facade;
import com.miracle.eva.service.util.RangeResult;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Getter
@Setter
public abstract class Controller<E, ID> implements Serializable {

    private Logger logger = Logger.getGlobal();

    protected E e;
    protected List<E> eList;
    protected ID id;
    protected final Facade<E, ID> facade;
    protected int offset=0, limit=1500;

    protected Controller(Facade<E, ID> facade) {
        this.facade = facade;
    }

    @PostConstruct
    protected abstract void init();

    public void create(){
        facade.create(e);
        logger.log(Level.FINEST,e.toString() + " created at " + new Date());
    }
    public void edit(){
        facade.edit(e,id);
    }
    public void remove(){
        facade.remove(e);
    }

    public E findById(){
        setE(facade.findById(getId()));
        return getE();
    }

    public E findById(ID id){
        setId(id);
        return findById();
    }

    public List<E> findAll(){
        setEList(facade.findAll(new RangeResult(offset,limit)));
        return eList;
    }


}
