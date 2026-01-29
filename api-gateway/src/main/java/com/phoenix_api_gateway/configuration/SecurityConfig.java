package com.phoenix_api_gateway.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(csrf -> csrf.disable()) // CSRF disable
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/actuator/**").permitAll() // actuator open
                        .anyExchange().authenticated()           // baki sab secure
                )
                .httpBasic(withDefaults()); // reactive http basic auth

        return http.build();
    }


}
