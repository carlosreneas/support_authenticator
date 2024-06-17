package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	String username = "admin";
	String password = "1234";
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        .csrf(csrf -> csrf.disable()) // Desactivar CSRF de manera moderna
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
        )
        .httpBasic(customizer -> customizer.realmName("Config Server"));
    return http.build();
    }
	
    @Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername(username)
	         .password("{noop}" + password) // {noop} es para indicar que no se usa ningún tipo de codificación de contraseña
	         .roles("USER")
	         .build();
		return new InMemoryUserDetailsManager(user);
	}

}
