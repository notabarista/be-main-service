package com.notabarrista.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author codrea.tudor
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfiguration {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Main NAB API").description("Main Service").termsOfServiceUrl("")
				.version("0.0.1-SNAPSHOT").contact(new Contact("NotABarrista", "https://www.notabarrista.org/", "")).build();
	}

	@Bean
	public Docket configureControllerPackageAndConverters() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.notabarrista.controller")).paths(PathSelectors.any())
				.build().apiInfo(new ApiInfoBuilder().version("0.1").title("Main Service API")
						.description("Documentation Main Service API v0.1").build());
	}

}
