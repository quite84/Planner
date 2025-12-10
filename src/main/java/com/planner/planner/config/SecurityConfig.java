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
    	.csrf(csrf -> csrf.disable()) // 현재는 csrf의 설정을 비활성화 시키는 상태임 , 활성화 시킬때, csrf 함수를 정의해야함. 서버에서 csrf 토큰 발급 및 브라우저 전송, 쿠키 저장 및 쿠키 발송까지 front에서 작업 진행 해야함.
        .authorizeHttpRequests(authorize -> authorize
        		.requestMatchers("/**", "/css/**", "/js/**", "/images/**").permitAll()
        	    .anyRequest().authenticated()
        		);
        
        return http.build();
    }
    
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


