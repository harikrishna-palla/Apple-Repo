package com.apple.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	public Docket productApi() {
	return new Docket(DocumentationType.SWAGGER_2).select()
			.apis(RequestHandlerSelectors.basePackage("com.apple.product")).build()
			.apiInfo(metaInfo());
	}
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Swagger-REST Example API ",
				" swagger with rest services ",
				"1.0 ",
				"terms of service ",
				new Contact("HCL Tech ", " https://hcl.com", "harikrihnapa@hcl.com"),
				" My software licence ",
				" https://mylicence.url.com",
				new ArrayList());

		return apiInfo;
	}
}
