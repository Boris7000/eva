package com.miracle.eva.web.jsf.validator;

import com.miracle.eva.entity.user.User;
import com.miracle.eva.service.facade.post.PostFacade;
import com.miracle.eva.service.facade.user.UserFacade;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.BeanValidator;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class PostValidator  extends BeanValidator {

    @Inject
    PostFacade facade;


    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        if(userExists((String) value)){
            //throw new ValidatorException(new FacesMessage("User already exists"));
        }
    }

    private boolean userExists(String login){
        return false;
    }

}
