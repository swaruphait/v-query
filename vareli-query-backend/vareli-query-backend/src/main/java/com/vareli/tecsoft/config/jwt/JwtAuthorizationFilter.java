package com.vareli.tecsoft.config.jwt;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vareli.tecsoft.model.dto.MyUserDetails;
import com.vareli.tecsoft.serviceImpl.TokenRevocationService;
import com.vareli.tecsoft.serviceImpl.UserDetailsServiceImpl;



@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl myUserDetailsService;

    @Autowired
    private TokenRevocationService tokenRevocationService;


    public JwtAuthorizationFilter(JwtUtil jwtUtil, UserDetailsServiceImpl myUserDetailsService,
            TokenRevocationService tokenRevocationService) {

        this.jwtUtil = jwtUtil;
        this.myUserDetailsService = myUserDetailsService;
        this.tokenRevocationService = tokenRevocationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (token != null && !tokenRevocationService.isTokenRevoked(token)) {
                String username = jwtUtil.extractUsername(token);

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    MyUserDetails userDetails = (MyUserDetails) myUserDetailsService.loadUserByUsername(username);
                    // Validate the token and set the authentication in the SecurityContext

                        if (jwtUtil.validateToken(token, userDetails)) {
                            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                    username, null, new ArrayList<>());
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                        }
                    }

            }

        }

        chain.doFilter(request, response);
    } 
}
