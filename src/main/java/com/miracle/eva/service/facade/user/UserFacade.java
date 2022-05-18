package com.miracle.eva.service.facade.user;

import com.miracle.eva.service.actions.create.EntityCreator;
import com.miracle.eva.service.actions.read.EntityReader;
import com.miracle.eva.service.actions.read.user.UserReader;
import com.miracle.eva.service.actions.remove.EntityRemover;
import com.miracle.eva.service.actions.update.EntityUpdater;
import com.miracle.eva.service.facade.Facade;
import com.miracle.eva.service.util.RangeResult;
import com.miracle.eva.entity.user.User;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class UserFacade extends Facade<User, Long> implements IUserService, Serializable {

    public UserFacade(EntityCreator<User> creator,
                      EntityReader<User, Long> finder,
                      EntityUpdater<User, Long> updater,
                      EntityRemover<User, Long> remover) {
        super(User.class, creator, finder, updater, remover);
    }

    public User findByLogin(String login) {
        Optional<User> result = Optional.of(
                ((UserReader) finder).findByLogin(login)
        );

        return result.orElseThrow(() -> {
            throw new RuntimeException("user account not found");
        });
    }


    public List<User> findAllByFirstName(String s, RangeResult rangeResult){
        return ((UserReader) finder).findAllByFirstName(s,rangeResult);
    }
    public List<User> findAllByLastName(String s, RangeResult rangeResult){
        return ((UserReader) finder).findAllByLastName(s,rangeResult);
    }

}
