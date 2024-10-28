package tr.com.atessoft.productsrv.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringFoxConfig {
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("products").packagesToScan("tr.com.atessoft.productsrv.controller")
				.build();
	}

	@Bean
	public OpenAPI productsOpenAPI() {
		return new OpenAPI().info(new Info().title("Products API").description("Products API").version("1.0")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}