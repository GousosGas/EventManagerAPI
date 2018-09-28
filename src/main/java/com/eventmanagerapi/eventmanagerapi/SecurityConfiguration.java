package com.eventmanagerapi.eventmanagerapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("root")
                .password(encoder.encode("root"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/events")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/events/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/events/**")
                .hasRole("ADMIN")
                .and().csrf().disable();

    }
}


