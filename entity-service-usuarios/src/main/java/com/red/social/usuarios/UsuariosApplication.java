package com.red.social.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableDiscoveryClient
public class UsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

}
