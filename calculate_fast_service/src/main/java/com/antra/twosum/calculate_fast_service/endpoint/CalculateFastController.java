package com.antra.twosum.calculate_fast_service.endpoint;

import com.antra.twosum.calculate_fast_service.pojo.TwoSumInput;
import com.antra.twosum.calculate_fast_service.pojo.TwoSumResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

@RestController
public class CalculateFastController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculateFastController.class);

	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public TwoSumResponse calculateTwoSum(@RequestBody TwoSumInput input) {
		LOGGER.info("calling calculate service /calc endpoint");
		LOGGER.info("Received: " + input);
		Set<BigInteger> numbers = new HashSet<>(Arrays.asList(input.getArray()));
		List<BigInteger[]> result = new LinkedList<>();
		Iterator<BigInteger> ite = numbers.iterator();
		while (ite.hasNext()) {
			BigInteger n = ite.next();
			BigInteger target = input.getSum().subtract(n);
			if (numbers.contains(target)) {
				result.add(new BigInteger[]{n, target});
				ite.remove();
			}
		}
		LOGGER.info("Reponsed:" + result);
		return new TwoSumResponse(result);
	}

}
