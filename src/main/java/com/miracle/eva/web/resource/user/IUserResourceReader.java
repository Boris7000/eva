package com.miracle.eva.web.resource.user;

import jakarta.ws.rs.core.Response;

public interface IUserResourceReader {
    Response findByLogin(String login);

    Response findByFirstname(String login, int offset, int limit);

    Response findByLastName(String login, int offset, int limit);

}
