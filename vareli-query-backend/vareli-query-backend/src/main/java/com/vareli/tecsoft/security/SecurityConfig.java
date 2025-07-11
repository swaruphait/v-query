package com.vareli.tecsoft.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.vareli.tecsoft.config.jwt.JwtAuthenticationEntryPoint;
import com.vareli.tecsoft.config.jwt.JwtAuthorizationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] WHITE_LIST_URL = {
            "/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/api/open/**",
            "/uploadfile/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/swagger-ui.html"
    };

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthorizationFilter jwtAuthorizationFilter;

    @Autowired
    private JwtLogoutSuccessHandler jwtLogoutSuccessHandler;

    @Autowired
    private JwtAuthenticationEntryPoint point;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthorizationFilter jwtAuthorizationFilter,
            JwtLogoutSuccessHandler jwtLogoutSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.jwtLogoutSuccessHandler = jwtLogoutSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public CorsConfiguration corsConfiguration() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(List.of(
            "http://192.168.13.72:4200",
            "http://localhost:4200", 
            "http://localhost:8080",
            "http://localhost:2557", 
            "http://localhost:2558", 
            "http://localhost:2559", 
            "http://localhost:2560", 
            "http://192.168.13.21:4200",         
            "http://192.168.13.21:2557", 
            "http://192.168.13.21:2558", 
            "http://192.168.13.21:2559", 
            "http://192.168.13.21:2560", 
            "http://192.168.13.21:8080",
            "https://biogrenetech.com/",
            "https://namaste-desk.vercel.app/",
            "https://present-boss.vercel.app/",
            "https://biogrenetech.vercel.app/",
            "https://thetechplanner.vercel.app/",
            "https://vptladmin.vercel.app/"
        ));
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfig.setAllowedHeaders(List.of("*")); 
        corsConfig.setAllowCredentials(true); 
        return corsConfig;
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration()); 
        return source;
    }


    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {
    // http.csrf(csrf -> csrf.disable())
    // .cors(cors -> cors.configurationSource(corsConfigurationSource()))
    // .authorizeHttpRequests(auth -> auth
    // .requestMatchers("/auth/login", "/user/userRegister", "/user/forgotPassword")
    // .permitAll()
    // .requestMatchers("/swagger-ui/**", "/swagger-resources/**", "/uploadfile/**",
    // "/v3/api-docs/**", "/index.html", "/app/**")
    // .permitAll()
    // .anyRequest().authenticated())
    // .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
    // .sessionManagement(session ->
    // session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    // .logout(logout -> logout
    // .logoutUrl("/auth/logout")
    // .logoutSuccessHandler(jwtLogoutSuccessHandler));

    // http.addFilterBefore(jwtAuthorizationFilter,
    // UsernamePasswordAuthenticationFilter.class);
    // return http.build();
    // }

    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(auth -> auth
                .antMatchers(WHITE_LIST_URL)
                .permitAll()
                .anyRequest().authenticated())
            .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .logout(logout -> logout
                .logoutUrl("/auth/logout")
                .logoutSuccessHandler(jwtLogoutSuccessHandler));

        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    // SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.csrf(csrf -> csrf.disable())
    //             .cors(cors -> cors
    //                     .configurationSource(request -> {
    //                         CorsConfiguration corsConfig = new CorsConfiguration();
    //                         corsConfig.setAllowedOrigins(List.of("http://localhost:4200", "http://localhost:8080","http://192.168.13.21:2557"));
    //                         corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
    //                         corsConfig.setAllowedHeaders(List.of("*"));
    //                         corsConfig.setAllowCredentials(true);
    //                         return corsConfig;
    //                     }))
    //             .headers(header -> {
    //                 header
    //                         .contentSecurityPolicy(policy -> {
    //                             policy.policyDirectives(
    //                                     "frame-ancestors 'self' http://localhost:4200 http://localhost:8080; http://192.168.13.21:2557");
    //                         })
    //                         .frameOptions(frame -> frame.sameOrigin());
    //             })
    //             .authorizeHttpRequests(authz -> authz
    //                     .antMatchers(WHITE_LIST_URL).permitAll()
    //                     .anyRequest().authenticated())
    //             .exceptionHandling(ex -> ex
    //                     .authenticationEntryPoint(point))
    //             .sessionManagement(session -> session
    //                     .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    //             .logout(logout -> logout
    //                     .logoutUrl("/auth/logout")
    //                     .logoutSuccessHandler(jwtLogoutSuccessHandler));

    //     http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

    //     return http.build();
    // }

    
}
