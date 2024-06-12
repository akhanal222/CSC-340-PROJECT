/*
package com.CSC_340_PROJECT4.Project4.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_CUSTOMER")) {
                response.sendRedirect("/customer/home");
                return;
            } else if (authority.getAuthority().equals("ROLE_RESTAURANT_OWNER")) {
                response.sendRedirect("/restaurant-owners/home");
                return;
            } else if (authority.getAuthority().equals("ROLE_SYSADMIN")) {
                response.sendRedirect("/sysadmins/home");
                return;
            }
        }
        throw new IllegalStateException();
    }
}
*/
