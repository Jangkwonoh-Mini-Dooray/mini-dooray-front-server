package com.nhnacademy.minidooraygateway.config;


import com.nhnacademy.minidooraygateway.filter.OAuthEmailLoginFailureFilter;
import com.nhnacademy.minidooraygateway.service.CustomOAuth2UserService;
import com.nhnacademy.minidooraygateway.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(e -> e
                        .antMatchers("/redirect-index").authenticated()
                        .antMatchers("/**").permitAll())
                .formLogin(f -> f
                        .usernameParameter("id")
                        .passwordParameter("pw")
                        .loginPage("/login")
                        .defaultSuccessUrl("/projects"))
                .logout().and()
                .csrf().disable()
                .sessionManagement(s -> s.sessionConcurrency(sc -> sc
                                .maximumSessions(1)
                                .maxSessionsPreventsLogin(true))
                        .sessionFixation()
                        .none())
                .headers(h -> h.defaultsDisabled()
                        .frameOptions()
                        .sameOrigin())
                .oauth2Login(o -> o
                        .loginPage("/login")
                        .defaultSuccessUrl("/projects")
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService))
                .addFilterBefore(new OAuthEmailLoginFailureFilter(), OAuth2AuthorizationRequestRedirectFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(16);
    }

}
