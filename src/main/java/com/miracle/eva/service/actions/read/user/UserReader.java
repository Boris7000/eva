package com.miracle.eva.service.actions.read.user;

import com.miracle.eva.service.actions.read.EntityReader;
import com.miracle.eva.service.util.RangeResult;
import com.miracle.eva.entity.user.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserReader extends EntityReader<User, Long> implements IUserReader{

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByLogin(String login) {
        return (User) getfindAllQuery(new String[]{"login"},login).getSingleResult();
    }

    @Override
    public List<User> findAllByFirstName(String s, RangeResult rangeResult) {
        return rankedQueryResults(getfindAllQuery(new String[]{"first_name"},s),rangeResult);
    }

    @Override
    public List<User> findAllByLastName(String s, RangeResult rangeResult) {
        return rankedQueryResults(getfindAllQuery(new String[]{"last_name"},s),rangeResult);
    }


}
