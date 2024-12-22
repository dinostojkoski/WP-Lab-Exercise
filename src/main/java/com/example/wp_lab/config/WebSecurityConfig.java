package com.example.wp_lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // Disables CSRF protection (common in APIs or certain apps)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/songs", "/artists", "songDetails", "/assets/**", "/register").permitAll() // Allow access to these pages without authentication
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict "/admin/**" paths to users with ADMIN role
                        .anyRequest().authenticated() // Require authentication for any other request
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Define a custom login page
                        .permitAll() // Allow everyone to access the login page
                        .failureUrl("/login?error=BadCredentials") // URL to redirect to on login failure
                        .defaultSuccessUrl("/songs", true) // Redirect to "/products" on successful login
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout") // Define the URL to trigger logout
                        .clearAuthentication(true) // Clear authentication upon logout
                        .invalidateHttpSession(true) // Invalidate session on logout
                        .deleteCookies("JSESSIONID") // Delete session cookie upon logout
                        .logoutSuccessUrl("/songs") // Redirect to login page after logout
                )
                .exceptionHandling((ex) -> ex
                        .accessDeniedPage("/access-denied")
                );


        return http.build(); // Return the configured SecurityFilterChain
    }

    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("ds")
                .password(passwordEncoder.encode("ds"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }
}
