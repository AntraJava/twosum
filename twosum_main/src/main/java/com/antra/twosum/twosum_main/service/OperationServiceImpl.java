package com.antra.twosum.twosum_main.service;

import com.antra.twosum.twosum_main.pojo.TwoSumInput;
import com.antra.twosum.twosum_main.pojo.TwoSumResponse;
import com.antra.twosum.twosum_main.pojo.UserInput;
import com.antra.twosum.twosum_main.pojo.UserResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
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
}
