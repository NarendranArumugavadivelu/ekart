package com.cooper.farming;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.cooper.farming.utils.CommonUtils;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CooperFarmingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooperFarmingApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
	
	@Bean(name = "errorProperties")
	public Properties getErrorProperties() {
		return CommonUtils.loadProperties("error-messages.properties");
	}
	
	@Bean
    public OpenAPI openAPI() {
		return new OpenAPI().components(new Components()).info(new Info().version("1.0.0").title("Cooper Farming Application"));
    }

}
