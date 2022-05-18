package com.miracle.eva.service.actions.create.user;

import com.miracle.eva.service.actions.create.EntityCreator;
import com.miracle.eva.entity.user.User;
import jakarta.ejb.Stateless;

@Stateless
public class UserCreator extends EntityCreator<User> {
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
