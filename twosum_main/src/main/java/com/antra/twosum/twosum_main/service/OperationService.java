package com.antra.twosum.twosum_main.service;

import com.antra.twosum.twosum_main.pojo.TwoSumResponse;
import com.antra.twosum.twosum_main.pojo.UserInput;
import com.antra.twosum.twosum_main.pojo.UserResponse;

public interface OperationService {
	UserResponse service(UserInput input);
}
