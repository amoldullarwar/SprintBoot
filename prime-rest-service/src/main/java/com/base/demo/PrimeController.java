package com.base.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {



	@GetMapping("/primes/{number}")
	public PrimeList getPrimeList(@PathVariable("number") int number) {

		PrimeList primeList = new PrimeList();
		primeList.setInitial(number);
		primeList.setPrimes(PrimeUtil.primeNumList(number));
		return primeList;
	}

	
}
