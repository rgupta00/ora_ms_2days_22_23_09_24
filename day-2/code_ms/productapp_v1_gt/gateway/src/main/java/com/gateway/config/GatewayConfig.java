package com.gateway.config;

import java.time.LocalDateTime;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	RouteLocator routeConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(p -> p.path("/shoppingapp/productservice/**")
						.filters(f -> f.rewritePath("/shoppingapp/productservice/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("productCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://PRODUCTS"))
				.route(p -> p.path("/shoppingapp/customerservice/**")
						.filters(f -> f.rewritePath("/shoppingapp/customerservice/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("customerCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://CUSTOMERS"))
				.route(p -> p.path("/shoppingapp/orderservice/**")
						.filters(f -> f.rewritePath("/shoppingapp/orderservice/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("ordersCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://ORDERS"))
				.route(p -> p.path("/shoppingapp/couponservice/**")
						.filters(f -> f.rewritePath("/shoppingapp/couponservice/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("couponCircuitBreaker")
										.setFallbackUri("forward:/contactSupport")))
						.uri("lb://COUPONS"))
				.build();
	}
}