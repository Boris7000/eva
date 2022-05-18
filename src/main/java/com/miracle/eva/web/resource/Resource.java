package com.miracle.eva.web.resource;

import com.miracle.eva.service.actions.IActions;
import com.miracle.eva.service.util.RangeResult;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

public  abstract class Resource<E, ID> implements IResource<E, ID>{

    protected final IActions<E, ID> serviceFacade;
    protected Resource(IActions<E, ID> serviceFacade){
        this.serviceFacade = serviceFacade;
    }

    @Override
    public Response findById(ID id) {
        return Response.accepted(serviceFacade.findById(id)).build();
    }


    @Override
    public Response findAll(int offset, int limit) {
        return Response.accepted(
                serviceFacade.findAll(new RangeResult(offset,limit))
        ).build();
    }

    @Override
    public Response create(E entity) {
        serviceFacade.create(entity);
        return Response.created(URI.create("")).build();
    }


    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Override
    public Response edit(E entity, ID id) {
        serviceFacade.edit(entity,id);
        return Response.noContent().build();
    }

    @Override
    public Response remove(ID id) {
        serviceFacade.remove(serviceFacade.findById(id));
        return Response.noContent().build();
    }

    @GET
    @Override
    public Long count() {
        return serviceFacade.count();
    }

    protected Response returnAcceptedWithEntity(Object entity){
        return Response.accepted(entity).build();
    }
}
