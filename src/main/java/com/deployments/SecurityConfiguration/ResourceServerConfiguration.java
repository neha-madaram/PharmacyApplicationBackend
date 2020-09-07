
package com.deployments.SecurityConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableResourceServer
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**").permitAll();

        /*http.requestMatchers().antMatchers("/test/ok").and().authorizeRequests()
                .antMatchers("/test/ok").access("hasRole('USER')")
                .and().requestMatchers().antMatchers("/patient/**")
                .and().authorizeRequests()
                .antMatchers("/patient/**").access("hasRole('ADMIN')");;

*/



    }

    }


