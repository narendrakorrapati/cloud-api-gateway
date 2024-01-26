package com.narendra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
	
	@Value("${microservices.endpoint.config-client}")
	private String configClientURL;
	
	@Value("${microservices.endpoint.settlement-service}")
	private String settlementServiceURL;
	
	@Value("${microservices.endpoint.dispute-service}")
	private String dispuerServiceURL;
	

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("config-client", prespec -> prespec.path("/config-client/**")
						.filters(gatewayFilter -> gatewayFilter.addRequestHeader("Hello", "World"))
						.uri(configClientURL))
				.route("settlement-service", prespec -> prespec.path("/settlement-service/**")
						.uri(settlementServiceURL))
				.route("disput-service", prespec -> prespec.path("/dispute-service/**")
						.uri(dispuerServiceURL))
				.build();
	}
}
