package com.antra.twosum.twosum_main.pojo;


import java.math.BigInteger;
import java.util.Arrays;

public class UserInput {
	private OperationType type;
	private BigInteger result;
	private BigInteger[] array;

	public BigInteger getResult() {
		return result;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public void setResult(BigInteger result) {
		this.result = result;
	}

	public BigInteger[] getArray() {
		return array;
	}

	public void setArray(BigInteger[] array) {
		this.array = array;
	}

	@Override
	public String toString() {
		return "UserInput{" +
				"type=" + type +
				", result=" + result +
				", array=" + Arrays.toString(array) +
				'}';
	}
}
