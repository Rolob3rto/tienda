package com.rolob3rto.springprojects.tienda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.rolob3rto.springprojects.tienda.services.UserService;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance();
    }
    
    @Bean
    UserService myUserService(){

        
        
        return new UserService();
    }

    /* @Bean
    public UserDetailsService user(){
        
        UserDetails user = User.builder()
            .username("user")
            .password("{noop}1234")
            //.password("1234")
            .authorities("USER")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}1234")
            //.password("1234")
            .authorities("USER","ADMIN")
            .build();        

        return new InMemoryUserDetailsManager(user, admin);
    } */

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(myUserService());
        authProvider.setPasswordEncoder(passwordEncoder());


        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        
        http
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
        .and()
            .formLogin()
        .and()
            .httpBasic();

        return http.build();
    }
}