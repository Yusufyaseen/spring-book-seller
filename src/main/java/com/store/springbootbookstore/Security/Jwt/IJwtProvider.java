package com.store.springbootbookstore.Security.Jwt;

import com.store.springbootbookstore.Security.UserPrinciples;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken(UserPrinciples user);

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);
}
