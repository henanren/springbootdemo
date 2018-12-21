package com.laomn.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.annotation.PostConstruct;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.laomn.controller.HelloResource;

/**
 * Created by jinli on 2017/8/18.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

	@Value("${spring.jersey.application-path:/}")
	private String apiPath;

	public JerseyConfig() {
		// Register endpoints, providers, ...
		this.registerEndpoints();
	}

	@PostConstruct
	public void init() {
		// Register components where DI is needed
		this.configureSwagger();
	}

	private void registerEndpoints() {
		this.register(HelloResource.class);
		// Access through /<Jersey's servlet path>/application.wadl
		this.register(WadlResource.class);
	}

	private void configureSwagger() {
		// Available at localhost:port/api/swagger.json
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setConfigId("springboot-jersey-swagger-docker-example");
		config.setTitle("Spring Boot + Jersey + Swagger + Docker Example");
		config.setVersion("v1");
		config.setContact("Orlando L Otero");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath(this.apiPath);
		config.setResourcePackage("com.laomn.controller");
		config.setPrettyPrint(true);
		config.setScan(true);
	}
}
