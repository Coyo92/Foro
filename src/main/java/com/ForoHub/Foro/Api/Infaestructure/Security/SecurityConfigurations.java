package com.ForoHub.Foro.Api.Infaestructure.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

         httpSecurity
                 .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.csrf ( Customizer.withDefaults() )
                //.disable ( )
                //.sessionManagement ( )
                //.sessionCreationPolicy( SessionCreationPolicy.STATELESS) // Le indicamos a Spring el tipo de sesion
                //.and()
                //.authorizeRequests()
                //.authorizeHttpRequests(authorize -> authorize
                //        .requestMatchers( HttpMethod.POST, "/login").permitAll()
                //        .requestMatchers("/swagger/**", "/v3/**","/swagger-ui/**").permitAll()
                //        .anyRequest()
                //        .authenticated()
                //)
                //.and()
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                //.build();
                //;
                ;
         return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ();
    }
}
