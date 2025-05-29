package com.vareli.tecsoft.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.vareli.tecsoft.config.jwt.JwtUtil;
import com.vareli.tecsoft.serviceImpl.TokenRevocationService;




@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {
   private final TokenRevocationService TokenRevocationService;

    private final JwtUtil jwtUtil;

    public JwtLogoutSuccessHandler(TokenRevocationService TokenRevocationService, JwtUtil jwtUtil) {
        this.TokenRevocationService = TokenRevocationService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String extractToken = jwtUtil.extractToken(request);
        TokenRevocationService.revokeToken(extractToken);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Logout Successful");
        response.getWriter().flush();
    } 
}
