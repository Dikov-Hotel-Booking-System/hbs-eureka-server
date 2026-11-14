package ru.mephi.hbs.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HbsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HbsEurekaServerApplication.class, args);
	}

}
