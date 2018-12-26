package com.github.sankowskiwojciech.bookhunter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String REGISTER_ENDPOINT = "/api/user/register";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().ignoringAntMatchers(REGISTER_ENDPOINT)
                .and()
                .authorizeRequests()
                .antMatchers("/", REGISTER_ENDPOINT).permitAll()
                .anyRequest().authenticated();
    }
}
