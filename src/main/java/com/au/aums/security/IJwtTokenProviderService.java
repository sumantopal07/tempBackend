package com.au.aums.security;


import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.au.aums.enums.Role;



public interface IJwtTokenProviderService {
    String createToken(String username, Role role);
    Authentication validateUserAndGetAuthentication(String token);
    String getUsername(String token);
    String parseToken(HttpServletRequest req);
    boolean validateToken(String token);

}
