package com.miracle.eva.web.jsf.controller.user;

import com.miracle.eva.entity.user.User;
import com.miracle.eva.service.facade.user.UserFacade;
import com.miracle.eva.web.jsf.controller.Controller;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@SessionScoped
public class UserController extends Controller<User, Long> {

    @Inject
    protected UserController(UserFacade facade) {
        super(facade);
    }

    @NotEmpty(message = "login не может быть пустым")
    @NotNull
    @Size(max = 200, min = 8, message = "login length must be between 8 and 20.")
    private String login;

    @NotEmpty
    @Size(max = 255, min = 8, message = "password length must be greater than or equal to 8.")
    @NotNull
    private String password;

    @NotNull
    private String first_name;
    @NotNull
    private String last_name;

    private User currentUser;

    private UsernamePasswordCredential credential;

    @PostConstruct
    @Override
    protected void init() {
        e = new User();
        currentUser = new User();
    }

    public void updateUser(){
        if(e.getId()!=null&&currentUser.getId()!=null&&e.getId().equals(currentUser.getId())){
            currentUser = findById(currentUser.getId());
        }
    }

    public void createUser(){
        currentUser.setLogin(login);
        currentUser.setPassword(password);
        currentUser.setFirst_name(first_name);
        currentUser.setLast_name(last_name);
        credential = new UsernamePasswordCredential(login, password);
        super.create();
    }

    public String updateUserInfo(){
        currentUser.setFirst_name(first_name);
        currentUser.setLast_name(last_name);
        facade.edit(currentUser, currentUser.getId());
        return "/jsf/public/user/user.xhtml?faces-redirect=true&id="+currentUser.getId();
    }

    public String logIn(){
        currentUser = ((UserFacade)facade).findByLogin(login);
        if(currentUser!=null&&password.equals(currentUser.getPassword())){
            return "/jsf/public/user/user.xhtml?faces-redirect=true&id="+currentUser.getId();
        } else {
            return "/jsf/public/user/login.xhtml";
        }
    }

    public String logOut(){
        init();
        return "/jsf/public/user/login.xhtml?faces-redirect=true";
    }

    public String registration(){
        createUser();
        return logIn();
    }
}
