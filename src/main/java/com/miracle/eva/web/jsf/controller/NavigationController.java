package com.miracle.eva.web.jsf.controller;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.event.ActionEvent;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Named
@SessionScoped
public class NavigationController implements Serializable {

    /*
        UserController userController = (UserController) FacesContext.getCurrentInstance().
                getExternalContext().getSessionMap().get("userController");
         */

    Long id;

    public void attrListener(ActionEvent event){

        id = (Long)event.getComponent().getAttributes().get("id");

    }


    @ManagedProperty(value = "#{param.userId}")
    private String userId;

    public String showFeed(){
        return "/jsf/public/post/feed.xhtml?faces-redirect=true";
    }

    public String showUserPage(){
        return "/jsf/public/user/user.xhtml?faces-redirect=true&id="+id;
    }

    public String showUserPage(Long id){
        return "/jsf/public/user/user.xhtml?faces-redirect=true&id="+id;
    }

    public String showLogin(){
        return "/jsf/public/user/login.xhtml?faces-redirect=true";
    }

    public String showRegistration(){
        return "/jsf/public/user/registration.xhtml?faces-redirect=true";
    }

    public String showChangeInfo(){
        return "/jsf/public/user/change-info.xhtml?faces-redirect=true";
    }

}
