package com.cooper.farming.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cooper.farming.exception.CustomAccessDeniedHandler;
import com.cooper.farming.exception.CustomAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class FarmingSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	private final UserDetailsService userDetailsService;

	public FarmingSecurityConfiguration(CustomAuthenticationEntryPoint customAuthenticationEntryPoint, @Qualifier("farmingUserDetailsService") UserDetailsService userDetailsService) {
		this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
	    this.userDetailsService = userDetailsService;
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	    provider.setPasswordEncoder(passwordEncoder());
	    provider.setUserDetailsService(userDetailsService);
	    return provider;
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()
	        .authorizeRequests()
	        .antMatchers("/api/**").authenticated()
	        .anyRequest().authenticated()
	        .and().exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).accessDeniedHandler(new CustomAccessDeniedHandler());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers(HttpMethod.GET, "/api/roles").antMatchers(HttpMethod.POST, "/api/users").antMatchers("/h2-console/**").
	    	antMatchers("/swagger-ui.html/**").antMatchers("/swagger-ui/**").antMatchers("/v3/api-docs/**");
	}
	
}
