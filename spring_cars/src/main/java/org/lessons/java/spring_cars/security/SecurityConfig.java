package org.lessons.java.spring_cars.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // creo un metodo per la filterChain
    @Bean
    @SuppressWarnings("removal")
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // regole per i filtri
        httpSecurity.authorizeHttpRequests().requestMatchers("/cars/create", "/cars/edit/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/cars/**").hasAuthority("ADMIN")
                .requestMatchers("/optionals", "/optionals/**").hasAuthority("ADMIN")
                .requestMatchers("/**")
                .permitAll().and().formLogin().defaultSuccessUrl("/cars", true).and().logout().and()
                .exceptionHandling();

        return httpSecurity.build();
    }

    // elemento userDetails
    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {

        // creo un nuovo Provider di autenticazione
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        // recupero gli utenti via username tramite lo userDetailsService impostando il
        // servizio da utilizzare
        authenticationProvider.setUserDetailsService(userDetailsService());

        // elemento passwordEncoder
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        // ritorno il provider
        return authenticationProvider;
    }

    // creo i due Bean userDetailsService e passwordEncoder
    @Bean
    DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
