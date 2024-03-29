package com.tomisoft.f1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = { "/css/**", "/js/**", "/images/**", "/favicon.ico**", "/login.html", "/", "/api/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(authorize -> {
                    authorize.antMatchers(AUTH_WHITELIST).permitAll();
                    authorize.antMatchers("/save.html").hasAuthority("ADMIN");
                    authorize.anyRequest().authenticated();
                }).formLogin(form -> {
                    form.loginPage("/login.html");
                    form.loginProcessingUrl("/perform_login");
                    form.defaultSuccessUrl("/", false);
                    form.failureUrl("/login.html?error=true");
                }).logout(logout -> {
                    logout.logoutUrl("/logout");
                    logout.logoutSuccessUrl("/");
                    logout.permitAll();
                });
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
