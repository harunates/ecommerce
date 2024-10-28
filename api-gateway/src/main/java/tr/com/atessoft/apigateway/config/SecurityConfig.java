package tr.com.atessoft.apigateway.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
       serverHttpSecurity
       			.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange ->
                        exchange.pathMatchers("/**")
                                .permitAll()
                                .anyExchange()
                                .authenticated());        
       return serverHttpSecurity.build();
    }
    
    @Bean
	@Lazy(false)
	public Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> apis(RouteDefinitionLocator locator,
																  SwaggerUiConfigParameters swaggerUiConfigParameters) {
		Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();
		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service")).forEach(routeDefinition -> {
			String name = routeDefinition.getId().replaceAll("-service", "s");
			AbstractSwaggerUiConfigProperties.SwaggerUrl swaggerUrl = new AbstractSwaggerUiConfigProperties.SwaggerUrl(name, "/" + name, null);
			urls.add(swaggerUrl);
		});
		swaggerUiConfigParameters.setUrls(urls);
		return urls;
	}
}
