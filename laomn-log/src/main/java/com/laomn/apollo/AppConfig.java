package com.laomn.apollo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@Configuration
@EnableApolloConfig
public class AppConfig {
	@Bean
	public AnnotatedBean javaConfigBean() {
		return new AnnotatedBean();
	}
}
