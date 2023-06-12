package com.nhnacademy.minidooraygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
@ConfigurationPropertiesScan
public class MiniDoorayGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniDoorayGatewayApplication.class, args);
	}

}
