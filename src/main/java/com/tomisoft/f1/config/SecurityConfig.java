package com.tomisoft.f1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = { "/css/**", "/js/**", "/images/**", "/favicon.ico**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //@formatter:off
        http.authorizeRequests()
                //.requestMatchers(SecurityConfig::isFrameworkInternalRequest).permitAll()
                .antMatchers(SecurityConfig.AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/indextwo")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable();
        //@formatter:on

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
