package com.visservice.visservicetwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableEurekaClient
@RestController
@SpringBootApplication
public class VisservicetwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisservicetwoApplication.class, args);
	}

//	@Value("${message:Hello default}")
//	private String message;

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	private CheckService checkService;

	@GetMapping(value="/message2")
	public String getData(){

		return checkService.readData();
	}

}
