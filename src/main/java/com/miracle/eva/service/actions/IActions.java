package com.miracle.eva.service.actions;

import com.miracle.eva.service.util.RangeResult;

import java.util.List;

public interface IActions <E, ID>{
    void create(E e);
    void edit(E e, ID id);
    void remove(E e);
    E findById(ID id);

    List<E> findAll();
    List<E> findAll(RangeResult rangeResult);
    Long count();
}
