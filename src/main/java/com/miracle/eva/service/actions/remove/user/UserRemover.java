package com.miracle.eva.service.actions.remove.user;

import com.miracle.eva.service.actions.read.user.UserReader;
import com.miracle.eva.service.actions.remove.EntityRemover;
import com.miracle.eva.entity.user.User;
import jakarta.inject.Inject;

public class UserRemover extends EntityRemover<User, Long> {
    @Inject
    public UserRemover(UserReader finder) {
        super(User.class, finder);
    }
}
