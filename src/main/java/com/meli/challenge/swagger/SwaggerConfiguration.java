package com.meli.challenge.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.meli.challenge.constant.ApiConstant;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Autowired
	private ApiConstant apiConstant;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact();
		contact.setEmail(apiConstant.getEmail());
		contact.setName(apiConstant.getName());
		contact.setUrl(apiConstant.getUrl());

		return new ApiInfoBuilder().title(apiConstant.getTitle()).description(apiConstant.getDescription())
				.version(apiConstant.getVersion()).license("").licenseUrl("").build();

	}
}
