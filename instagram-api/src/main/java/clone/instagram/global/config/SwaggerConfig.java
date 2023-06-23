package clone.instagram.global.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Response;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		final List<Response> responseMessages = new ArrayList<>();
		responseMessages.add(new ResponseBuilder().code("405")
			.description("G002 - 허용되지 않은 HTTP method 입니다.").build());
		responseMessages.add(new ResponseBuilder().code("500")
			.description("G001 - 내부 서버 오류입니다.").build());

		return new Docket(DocumentationType.SWAGGER_2)
			.useDefaultResponseMessages(false)
			.globalResponses(HttpMethod.POST, responseMessages)
			.globalResponses(HttpMethod.GET, responseMessages)
			.globalResponses(HttpMethod.DELETE, responseMessages)
			.globalResponses(HttpMethod.PUT, responseMessages)
			.apiInfo(apiInfo())
			.securityContexts(List.of(securityContext()))
			.securitySchemes(List.of(apiKey()))
			.select()
			.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
			.paths(PathSelectors.any())
			.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("Instagram's API Docs")
			.version("1.0")
			.description("API 명세서")
			.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
			.securityReferences(defaultAuth())
			.build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope =
			new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes =
			new AuthorizationScope[1];

		authorizationScopes[0] = authorizationScope;
		return List.of(new SecurityReference("JWT", authorizationScopes));
	}

}
