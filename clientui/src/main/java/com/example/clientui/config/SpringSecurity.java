package com.example.clientui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

    //@Configuration
    //@EnableZuulProxy
    public class SpringSecurity extends WebSecurityConfigurerAdapter{
/*
       @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.antMatcher("/**")
                    .authorizeRequests()
                    //.antMatchers("/", "/login**")
                    //.permitAll()
                    .anyRequest()
                    //.permitAll();
                    .authenticated();

        }
*/
}
