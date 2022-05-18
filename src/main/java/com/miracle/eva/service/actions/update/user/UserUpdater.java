package com.miracle.eva.service.actions.update.user;

import com.miracle.eva.service.actions.update.EntityUpdater;
import com.miracle.eva.entity.user.User;
import jakarta.ejb.Stateless;

@Stateless
public class UserUpdater extends EntityUpdater<User, Long> {

    public UserUpdater() {
        super(User.class);
    }

    @Override
    protected User getEditedEntity(User source, User target) {
        target.setFirst_name(source.getFirst_name());
        target.setLast_name(source.getLast_name());
        target.setLogin(source.getLogin());
        target.setPassword(source.getPassword());
        return target;
    }
}
