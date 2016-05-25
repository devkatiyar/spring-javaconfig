package com.myproject.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value={ "classpath:datasource.properties" , "classpath:Test.properties"},ignoreResourceNotFound = true)
public class PropertiesConfigurtion {

	/*
	 * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}")
	 * annotations. Remove this bean if you are not using @Value annotations for
	 * injecting properties.
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer=new PropertySourcesPlaceholderConfigurer();
		//propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
		
		return propertySourcesPlaceholderConfigurer;
	}

}
