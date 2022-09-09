package com.store.springbootbookstore.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {
    public static final String formattedPrefix = "ROLE_";
    public static final String auth_header = "authorization";
    public static final String auth_token_type = "Bearer";
    public static final String auth_token_prefix = auth_token_type + " ";
    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole = role.startsWith(formattedPrefix) ? role : formattedPrefix + role;
        return new SimpleGrantedAuthority(formattedRole);
    }
    public static String extractToken(HttpServletRequest request){
        String bearerToken = request.getHeader(auth_header);
        System.out.println("bearer token " + bearerToken);
        if(StringUtils.hasLength(bearerToken) && bearerToken.startsWith(auth_token_prefix)){
            return bearerToken.substring(7);
        }
        return null;
    }
}
