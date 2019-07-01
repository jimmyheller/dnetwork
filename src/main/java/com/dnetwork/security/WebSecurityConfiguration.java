package com.dnetwork.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf()
                .disable()
                .antMatcher("/**").authorizeRequests().anyRequest()
                //.authorizeRequests()
                //.antMatchers("**.html", "**.js", "**.css")
                .permitAll();
        // @formatter:on

    }


}
