package com.antra.twosum.twosum_main.pojo;

import java.math.BigInteger;
import java.util.List;

public class TwoSumResponse {
	private TwoSumInput input;
	private List<BigInteger[]> result;

	public TwoSumResponse() {
	}

	public TwoSumResponse(List<BigInteger[]> result) {
		this.result = result;
	}

	public TwoSumResponse(TwoSumInput input, List<BigInteger[]> result) {
		this.input = input;
		this.result = result;
	}

	public TwoSumInput getInput() {
		return input;
	}

	public void setInput(TwoSumInput input) {
		this.input = input;
	}

	public List<BigInteger[]> getResult() {
		return result;
	}

	public void setResult(List<BigInteger[]> result) {
		this.result = result;
	}
}
