package com.planner.planner.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityConfig {
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
    	http
    	.cors(cors -> cors.configurationSource(corsConfigurationSource()))
    	.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorize -> authorize
        		.requestMatchers("/**", "/css/**", "/js/**", "/images/**").permitAll()
        	    .anyRequest().authenticated()
        		);
        
        return http.build();
    }
    
    /*
     *  csrf url 등록 과정 ignoringRequestMatchers으로 csrf 제외 url 등록 (제외 외에는 전부 csrf 적용) 
     *  즉, .csrf(csrf -> csrf.disable())을 삭제하면 됨.
     *   @Bean
     *   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     *   http
     *       // ... 다른 설정들
     *       .csrf(csrf -> csrf
     *       // '/api/**' 와 '/other-path/**' 경로는 CSRF 보호를 적용하지 않음
     *       .ignoringRequestMatchers("/api/**", "/other-path/**")
     *       )
     *       .authorizeHttpRequests(authorize -> authorize
     *       .requestMatchers("/**", "/css/**", "/js/**", "/images/**").permitAll()
     *       .anyRequest().authenticated()
     *       );
     *       return http.build();
     *       } 
     * */
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000");
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}


