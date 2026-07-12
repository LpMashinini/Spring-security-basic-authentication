package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( (authorize) ->{
                    authorize.anyRequest().authenticated();
                }).formLogin(Customizer.withDefaults());

        return http.build();

    }

    //Creating in-memory objects and stores them at InMemoryDetailsManager object

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails lebogang = User.builder()
                .username("lebogang")
                .password(passwordEncoder().encode("lebogang"))
                .roles("ADMIN")
                .build();

        UserDetails accaria = User.builder()
                .username("accartia")
                .password(passwordEncoder().encode("accartia"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(lebogang,accaria);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
