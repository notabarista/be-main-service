package com.notabarrista.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
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
		return new ApiInfoBuilder().title("Main NAB API").description("Aggregator Service").termsOfServiceUrl("")
				.version("0.0.1-SNAPSHOT").contact(new Contact("NotABarrista", "https://www.notabarrista.org/", "")).build();
	}

	@Bean
	public Docket configureControllerPackageAndConvertors() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.notabarrista.controller")).build().apiInfo(apiInfo())
				.tags(new Tag("Main API", "THE BEST MAIN API"));
	}

}
