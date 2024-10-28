package tr.com.atessoft.ordersrv.config;

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
		return GroupedOpenApi.builder().group("orders").packagesToScan("tr.com.atessoft.ordersrv.controller").build();
	}

	@Bean
	public OpenAPI productsOpenAPI() {
		return new OpenAPI().info(new Info().title("Orders API").description("Orders API").version("1.0")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}