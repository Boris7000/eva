package com.miracle.eva.web.resource;

import jakarta.ws.rs.core.Response;

public interface IResource<E, ID> {
    Response create(E entity);
    Response edit(E entity, ID id);
    Response findById( ID id);
    Response remove( ID id);
    Response findAll(int offset, int limit);
    Long count();
}
