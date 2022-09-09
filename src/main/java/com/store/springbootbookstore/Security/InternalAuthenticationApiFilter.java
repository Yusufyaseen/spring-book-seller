package com.store.springbootbookstore.Security;

import com.store.springbootbookstore.Security.Jwt.IJwtProvider;
import com.store.springbootbookstore.model.Role;
import com.store.springbootbookstore.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class InternalAuthenticationApiFilter extends OncePerRequestFilter {

    @Value("${authentication.internal-api-key}")
    private String internalApiKey;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getRequestURI().startsWith("/api/internal");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = SecurityUtils.extractToken(request);
        if (token != null && token.equals(internalApiKey)) {
            System.out.println("lll");
            UserPrinciples userPrinciples = UserPrinciples.makeAdmin();
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userPrinciples, null, userPrinciples.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
