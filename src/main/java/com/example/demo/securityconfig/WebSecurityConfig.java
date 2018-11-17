package com.example.demo.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

   /* @Override
    public void configure(WebSecurity web) throws Exception {
        getHttp().authorizeRequests().
                antMatchers("/showReg",
                        "/","/index.html",
                        "registerUser",
                        "/showLogin",
                        "/login/*").
                permitAll().antMatchers(
                        "/admin/showAddFlight").hasAuthority("Admin").
                anyRequest().authenticated().and().csrf().disable();



    }*/

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/showReg","/","/index.html","/registerUser","/showLogin","/login/**").permitAll()
                .antMatchers("/admin/showAddFlight").hasAuthority("ADMIN").anyRequest().authenticated()
                .and().csrf().disable();

//        .antMatchers(
//                "/admin/showAddFlight").hasAuthority("Admin").
//                anyRequest().authenticated()

    }
}
