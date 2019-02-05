package com.example.demo;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableScheduling
public class SwaggerConfig {

	@Bean
    public Docket JmsApi() {
		Parameter additionalHeaderParameter = new ParameterBuilder().name("feeCalculation").description("For fee calculations").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
		List<Parameter> additionalParameters = new ArrayList<Parameter>();
		additionalParameters.add(additionalHeaderParameter);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public-api")
                .apiInfo(apiInfo())
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .paths(postPaths()).build()
                .globalOperationParameters(additionalParameters);
    }
	
	private Predicate<String> postPaths(){
		return or(regex("api/posts.*"),regex("/api/.*")) ;
	}
	
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
      new HashSet<String>(Arrays.asList("application/json",
          "application/xml"));
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Fee Calculation API")
                .description("List of all the microservices APIs")
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.apache.org")
                .version("1.0")
                .build();
    }
}