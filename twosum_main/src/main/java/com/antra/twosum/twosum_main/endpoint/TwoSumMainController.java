package com.antra.twosum.twosum_main.endpoint;

import com.antra.twosum.twosum_main.pojo.TwoSumResponse;
import com.antra.twosum.twosum_main.pojo.UserInput;
import com.antra.twosum.twosum_main.pojo.UserResponse;
import com.antra.twosum.twosum_main.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TwoSumMainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TwoSumMainController.class);
	@Value("${com.antra.env}")
	private String envFromProperties;

	@Autowired
	OperationService operationService;

	@GetMapping("/")
	public String getEnv() {
		return "System is running and profile is " + envFromProperties;
	}

//Json body of the request
//	{
//		"type":"TWO_SUM",
//			"result": "4",
//			"array":[1,2,3,4,5]
//	}

	@PostMapping(value = "/twosum", consumes = "application/json")
	public ResponseEntity<UserResponse> getTwosum(@RequestBody UserInput input) {
		//validation
		LOGGER.info("calling main service twosum endpoint");
		LOGGER.info("Received: " + input);
		UserResponse tsResp = operationService.service(input);
		LOGGER.info("Responsed: " + tsResp);
		return new ResponseEntity<>(tsResp, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exceptionHanlder(Exception ex) {
		LOGGER.error("Error in Main Controller",ex);
		return new ResponseEntity<>("Bad things happened", HttpStatus.BAD_REQUEST);

	}
}
