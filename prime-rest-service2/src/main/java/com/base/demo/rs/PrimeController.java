package com.base.demo.rs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.base.demo.model.PrimeList;
import com.base.demo.service.PrimeNumberService;

@RestController
public class PrimeController {
	
	@Autowired
	PrimeNumberService primeNumberService;
	
	@GetMapping("/primes/{number}")
    public ResponseEntity<PrimeList> getPrimeList(@PathVariable("number") int number){
		
        List<Integer> primNumbersTill = primeNumberService.findPrimNumUpto(number);
        
        return ResponseEntity.ok(buildResponse(number, primNumbersTill));
    }
	
	private PrimeList buildResponse(int number, List<Integer> primNumbers) {
		PrimeList primeList = new PrimeList();
		primeList.setInitial(number);
		primeList.setPrimes(primNumbers);
		return primeList;
    }

}
