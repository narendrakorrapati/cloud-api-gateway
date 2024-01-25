package com.narendra;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(prespec -> prespec.path("/config-client/**")
						.filters(gatewayFilter -> gatewayFilter.addRequestHeader("Hello", "World"))
						.uri("http://localhost:8082"))
				.build();
	}
}
