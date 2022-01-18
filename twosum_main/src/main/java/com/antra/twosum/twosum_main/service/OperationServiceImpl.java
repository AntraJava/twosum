package com.antra.twosum.twosum_main.service;

import com.antra.twosum.twosum_main.endpoint.TwoSumMainController;
import com.antra.twosum.twosum_main.pojo.TwoSumInput;
import com.antra.twosum.twosum_main.pojo.TwoSumResponse;
import com.antra.twosum.twosum_main.pojo.UserInput;
import com.antra.twosum.twosum_main.pojo.UserResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletionStage;


@Service
public class OperationServiceImpl implements OperationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OperationServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;

	private static final String BACKEND = "backend";
	@Override
//	@Retry(name = BACKEND, fallbackMethod = "retryFallBack")
	@CircuitBreaker(name = BACKEND, fallbackMethod = "circuitFallBack")
	public UserResponse service(UserInput input) {
		TwoSumInput entity = new TwoSumInput();
		entity.setArray(input.getArray());
		entity.setSum(input.getResult());
		ResponseEntity<TwoSumResponse> response = restTemplate.exchange("http://CalcFastService/calc", HttpMethod.POST, new HttpEntity<>(entity),TwoSumResponse.class);
		UserResponse res = new UserResponse();
		res.setResults(response.getBody().getResult());
		res.setType(input.getType());
		return res;
	}

	private UserResponse circuitFallBack(UserInput input, Throwable e) {
		LOGGER.error("in circuit breaker");
		return null;
	}
	private UserResponse retryFallBack(UserInput input, Throwable e) {
		LOGGER.error("in retry ");
		return null;
	}

}
