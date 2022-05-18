package com.miracle.eva.web.resource.user;

import com.miracle.eva.entity.user.User;
import com.miracle.eva.service.facade.user.UserFacade;
import com.miracle.eva.service.facade.user.UserFacadeImpl;
import com.miracle.eva.service.util.RangeResult;
import com.miracle.eva.web.resource.Resource;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/users/")
public class UserResource extends Resource<User, Long> implements IUserResourceReader {

    @Inject
    public UserResource(UserFacade userAccountService) {
        super(userAccountService);
    }

    @GET
    @Path("{id}")
    @Override
    public Response findById(@PathParam("id") Long aLong) {
        return super.findById(aLong);
    }

    @GET
    @Path("login/{l}")
    @Override
    public Response findByLogin(@PathParam("l") String login) {
        return returnAcceptedWithEntity(((UserFacadeImpl) serviceFacade).findByLogin(login));
    }

    @GET
    @Path("first_name/{f}")
    @Override
    public Response findByFirstname(@PathParam("f") String f, @QueryParam("offset") int offset, @QueryParam("limit")int limit) {
        return returnAcceptedWithEntity(((UserFacadeImpl) serviceFacade).findAllByFirstName(f, new RangeResult(offset,limit)));
    }

    @GET
    @Path("last_name/{l}")
    @Override
    public Response findByLastName(@PathParam("l") String l, @QueryParam("offset") int offset, @QueryParam("limit")int limit) {
        return returnAcceptedWithEntity(((UserFacadeImpl) serviceFacade).findAllByLastName(l, new RangeResult(offset,limit)));
    }

    @GET
    @Override
    public Response findAll(@QueryParam("offset") int offset, @QueryParam("limit") int limit){
        return super.findAll(offset,limit);
    }


    @POST
    @Override
    public Response create(User entity) {
        return super.create(entity);
    }

    @DELETE
    @Path("{id}")
    @Override
    public Response remove(@PathParam("id") Long aLong) {
        return super.remove(aLong);
    }

    @PUT
    @Path("{id}")
    @Override
    public Response edit(User entity, @PathParam("id") Long aLong) {
        return super.edit(entity, aLong);
    }

    @GET
    @Path("/count")
    @Override
    public Long count() {
        return super.count();
    }
}
