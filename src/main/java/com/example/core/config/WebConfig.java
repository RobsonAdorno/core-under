//package com.example.core.config;
//
//import com.example.core.security.JWTAuthenticationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class WebConfig {
//    private final JWTAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//    private final LogoutHandler logoutHandler;
//
//    private static final String[] PUBLIC_MATCHERS = {
//            "/login"
//    };
//
//    private static final String[] PUBLIC_MATCHERS_GET = {
//            "/client/**",
//            "/product/**",
//            "/order/**",
//            "/item/**",
//    };
//
//    private static final String[] PUBLIC_MATCHERS_POST = {
//            "/client/**",
//            "/product",
//            "/order/**",
//            "/item/**",
//    };
//
//    private static final String[] PUBLIC_MATCHERS_DELETE = {
//            "/client"
//    };
//
//    private static final String[] PUBLIC_MATCHERS_PUT = {
//            "/client"
//    };
//
//    private static final Map<String, String> map = new HashMap<>();
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
////       return http
////                .csrf().and().cors().disable()
////                .authorizeHttpRequests()
////                .requestMatchers(new Teste())
////                .permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authenticationProvider(authenticationProvider)
////                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
////                .logout()
////                .logoutUrl("/api/v1/auth/logout")
////                .addLogoutHandler(logoutHandler)
////                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
//
//        return http
//                .csrf().and().cors().disable()
//                .authorizeHttpRequests()
//                .requestMatchers(new Teste())
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
//
////        return http.csrf().disable().build();
//    }
//}
//
//class Teste implements RequestMatcher {
//
//    @Override
//    public boolean matches(HttpServletRequest request) {
//        return true;
//    }
//
//    @Override
//    public MatchResult matcher(HttpServletRequest request) {
//        return RequestMatcher.super.matcher(request);
//    }
//}
