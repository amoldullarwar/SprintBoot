package com.base.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimeList {

	@JsonProperty(value = "Initial")
	private int initial;

	@JsonProperty(value = "Primes")
	private List<Integer> primes;

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}

}
