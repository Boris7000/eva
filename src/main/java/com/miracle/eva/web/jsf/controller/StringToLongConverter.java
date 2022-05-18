package com.miracle.eva.web.jsf.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class StringToLongConverter {
    public Long convert(String value){
        return Long.parseLong(value);
    }

}
