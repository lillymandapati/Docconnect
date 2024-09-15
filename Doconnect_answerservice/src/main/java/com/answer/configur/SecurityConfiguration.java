package com.answer.configur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationFilter jwtFilter;

	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(AbstractHttpConfigurer::disable).headers().frameOptions().disable().and() 
																									
																									
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/swagger-resources/**", "/swagger-ui*/**", "/v2/api-docs", "/v3/api-docs/**",
								"/webjars/**", "/h2-console")
						.permitAll().requestMatchers("/h2-console/**").permitAll()
						.requestMatchers(RolesConstants.ADMIN).hasRole("ADMIN")
						.requestMatchers(RolesConstants.USER).hasAnyRole("USER", "ADMIN")

						.anyRequest().authenticated())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(entryPoint)
						.accessDeniedHandler(accessDeniedHandler))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider());
		return httpSecurity.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationEntryPoint authenticationEntryPoint() {
		return new JwtAuthenticationEntryPoint();
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		return authentication -> authentication;
	}

}
