package com.base.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeUtil {

	public static List<Integer> primeNumList(int number) {
		List<Integer> primeNumList = new ArrayList();
		Stream.iterate(0, n -> n + 1)
			  .limit(number + 1)  // Added extra 1 to include last digit for prime check
			  .filter(PrimeUtil::isPrime)
			  .forEach(primeNumList::add);
		
		return primeNumList;
	}

	public static boolean isPrime(int number) {
		if (number <= 1)
			return false; // 1 is not prime and also not composite
		int i = 2;
		boolean flag = false;
		while (i <= number / 2) {
			if (number % i == 0) {
				flag = true;
				break;
			}
			++i;
		}

		return !flag;
	}

}