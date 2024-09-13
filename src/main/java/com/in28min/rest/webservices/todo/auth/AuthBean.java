package com.in28min.rest.webservices.todo.auth;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;

@Getter
@Setter
public class AuthBean {
    private String authString;
    public AuthBean(String authString) {
        this.authString = authString;
        System.out.println(authString);
    }
}
