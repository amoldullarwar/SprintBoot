package com.base.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimeUtilTest {

	@Test
	public void isPrimeTest(){
		
		boolean isPrimeActual = PrimeUtil.isPrime(10);
		// To test invalid prime number scenario
		assertEquals(false, isPrimeActual);
		
		boolean isPrimeActual2 = PrimeUtil.isPrime(2);
		// To test valid  prime number scenario
		assertEquals(true, isPrimeActual2);
		
		boolean isPrimeActual3 = PrimeUtil.isPrime(3);
		// To test valid prime number scenario
		assertEquals(true, isPrimeActual3);
	}
	
	
	@Test
	public void primeListTest(){
		
		List<Integer> primeNumListActual = PrimeUtil.primeNumList(10);
		List<Integer> primeNumListExpected = new ArrayList<Integer>();
		primeNumListExpected.add(2);
		primeNumListExpected.add(3);
		primeNumListExpected.add(5);
		primeNumListExpected.add(7);
		
		// To test prime number list size scenario
		assertEquals(4, primeNumListActual.size());

		
		// To test prime number list comparison
		assertEquals(primeNumListExpected, primeNumListActual);
		
		// To test prime number list comparison for unexpected list
		primeNumListExpected.add(10);
		List<Integer> primeNumListUnExpected = primeNumListExpected;
		
		assertNotEquals(primeNumListUnExpected, primeNumListActual);

		
	}
}