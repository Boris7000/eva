package com.miracle.eva.service.actions.read.user;

import com.miracle.eva.service.util.RangeResult;
import com.miracle.eva.entity.user.User;

import java.util.List;

public interface IUserReader {
    User findByLogin(String login);
    List<User> findAllByFirstName(String s, RangeResult rangeResult);
    List<User> findAllByLastName(String s, RangeResult rangeResult);
}
