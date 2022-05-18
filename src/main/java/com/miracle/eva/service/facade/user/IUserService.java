package com.miracle.eva.service.facade.user;

import com.miracle.eva.service.actions.IActions;
import com.miracle.eva.service.util.RangeResult;
import com.miracle.eva.entity.user.User;

import java.util.List;

public interface IUserService extends IActions<User,Long> {

    User findByLogin(String login);
    List<User> findAllByFirstName(String s, RangeResult rangeResult);
    List<User> findAllByLastName(String s, RangeResult rangeResult);

}
