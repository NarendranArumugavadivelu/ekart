package com.cooper.farming.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class FarmingResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Value("${resources.id}")
	private String resourcesId;
	

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(resourcesId);
	}
}
