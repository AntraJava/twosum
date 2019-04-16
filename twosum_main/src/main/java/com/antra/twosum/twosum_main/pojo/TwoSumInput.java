package com.antra.twosum.twosum_main.pojo;

import java.math.BigInteger;

public class TwoSumInput {
	private BigInteger sum;
	private BigInteger[] array;

	public TwoSumInput() {}

	public TwoSumInput(BigInteger sum, BigInteger[] array) {
		this.sum = sum;
		this.array = array;
	}

	public BigInteger getSum() {
		return sum;
	}

	public void setSum(BigInteger sum) {
		this.sum = sum;
	}

	public BigInteger[] getArray() {
		return array;
	}

	public void setArray(BigInteger[] array) {
		this.array = array;
	}
}
