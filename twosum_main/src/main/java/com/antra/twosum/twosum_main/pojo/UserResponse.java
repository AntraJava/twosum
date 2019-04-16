package com.antra.twosum.twosum_main.pojo;

import java.math.BigInteger;
import java.util.List;

public class UserResponse {
	private OperationType type;
	private List<BigInteger[]> results;

	public UserResponse() {
	}

	public UserResponse(OperationType type, List<BigInteger[]> results) {
		this.type = type;
		this.results = results;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public List<BigInteger[]> getResults() {
		return results;
	}

	public void setResults(List<BigInteger[]> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "UserResponse{" +
				"type=" + type +
				", results=" + results +
				'}';
	}
}
