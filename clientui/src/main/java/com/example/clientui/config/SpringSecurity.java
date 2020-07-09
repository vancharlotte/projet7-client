package com.example.clientui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableOAuth2Sso
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .logout()    //logout configuration
                .logoutRequestMatcher(new AntPathRequestMatcher ("/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("UISESSION", "JSESSIONID")
                .clearAuthentication(true)
                .invalidateHttpSession(true);

        // .and().logout().logoutSuccessUrl("/").permitAll();
    }




}
