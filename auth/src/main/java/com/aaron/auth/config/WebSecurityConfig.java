package com.aaron.auth.config;

import com.aaron.auth.AuthEntryPoint;
import com.aaron.auth.AuthFailHandler;
import com.aaron.auth.AuthSuccHandler;
import com.aaron.auth.LogoutSuccHandler;
import com.aaron.auth.impl.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by com.aaron on 7/13/17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/index.html", "/fail.html", "/success.html").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .authenticationProvider(new AuthProviderImpl())
                .formLogin()
                    .loginPage("/login.html").permitAll()
                    .successHandler(new AuthSuccHandler())
                    .failureHandler(new AuthFailHandler())
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessHandler(new LogoutSuccHandler())
                    .and()
                .exceptionHandling()
                    .authenticationEntryPoint(new AuthEntryPoint());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("username").password("password").roles("USER");
    }
}
