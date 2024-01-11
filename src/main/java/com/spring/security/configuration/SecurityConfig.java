package com.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);

//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();          //логин пароль и роль заданы в самой программе
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("Andrey")
//                        .password("Andrey")
//                        .roles("MANAGER"))
//                .withUser(userBuilder.username("Ira")
//                        .password("Ira")
//                        .roles("HR"))
//                .withUser(userBuilder.username("Vlad")
//                        .password("Vlad")
//                        .roles("DIRECTOR", "HR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("DIRECTOR", "HR", "MANAGER")
                .antMatchers("/he_info").hasRole("HR")
                .antMatchers("/director_info/**").hasRole("DIRECTOR")
                .and().formLogin().permitAll();
    }
}
