package com.cooper.farming.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class FarmingOAuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final AuthenticationManager authenticationManager;
	
	private final UserDetailsService userService;
	
	@Value("${client.id}")
	private String clientId;

	@Value("${client.password}")
	private String clientSecret;

	@Value("${client.accessTokenValiditySeconds}")
	private int accessTokenValiditySeconds;

	@Value("${client.authorizedGrantTypes}")
	private String[] authorizedGrantTypes;

	@Value("${client.refreshTokenValiditySeconds}")
	private int refreshTokenValiditySeconds;
	
	public FarmingOAuthServerConfiguration(AuthenticationManager authenticationManager, UserDetailsService userService) {
		this.authenticationManager = authenticationManager;
	    this.userService = userService;
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
	    	.withClient(clientId)
	        .secret(clientSecret)
	        .accessTokenValiditySeconds(accessTokenValiditySeconds)
	        .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
	        .authorizedGrantTypes(authorizedGrantTypes)
	        .scopes("read", "write")
	        .resourceIds("api");
	}
	
	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints
	    	.accessTokenConverter(accessTokenConverter())
	        .userDetailsService(userService)
	        .authenticationManager(authenticationManager);
	}

	
	@Bean
	JwtAccessTokenConverter accessTokenConverter() {
		return new JwtAccessTokenConverter();
	}
}
