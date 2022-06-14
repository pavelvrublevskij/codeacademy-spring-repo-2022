package eu.codeacademy.eshop.security.basic.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalUser {

    private String username;
    private String password;
    private String[] roles;
}
