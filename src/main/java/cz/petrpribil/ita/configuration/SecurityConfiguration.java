package cz.petrpribil.ita.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final SecurityConfigurationProperties securityConfigurationProperties;

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests((authz) -> authz
                        .antMatchers(HttpMethod.GET, "/api/v1/products/**", "/api/v1/authors/**", "/api/v1/genres/**", "/api/v1/carts/**")
                        .permitAll()
                        .antMatchers(HttpMethod.POST, "/api/v1/orders/**", "/api/v1/carts/**")
                        .permitAll()
                        .antMatchers(HttpMethod.PUT, "/api/v1/carts/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration()
                .setAllowedOriginPatterns(List.of(securityConfigurationProperties.getFrontendUrl()));
        corsConfiguration.setAllowedMethods(securityConfigurationProperties.getAllowedMethods());
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

}

