package com.antra.twosum.twosum_main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TwosumMainApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TwosumMainApplication.class);

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		LOGGER.info(globalProp);
		return new RestTemplate();
	}

	@Value("${com.antra.globalProp}")
	private String globalProp;

	public static void main(String[] args) {
		SpringApplication.run(TwosumMainApplication.class, args);
	}

}
