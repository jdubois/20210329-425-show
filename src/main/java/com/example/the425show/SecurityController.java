package com.example.the425show;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello, " + authentication.getName()  +
                " your email is " +
                ((DefaultOidcUser) authentication.getPrincipal()).getEmail() +
                "! You have the roles: " +
                authentication.getAuthorities() ;
    }
}
