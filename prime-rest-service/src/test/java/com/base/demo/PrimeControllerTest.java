package com.base.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PrimeController.class)
public class PrimeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getPrimeListJSONNegateTest() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/primes/10").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"Initial\":10,\"Primes\":[2,3,5,7]}";

		String unExpected = "{\"Initial\":11,\"Primes\":[2,3,5,7,11]}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
		assertNotEquals(unExpected, result.getResponse()
				.getContentAsString());
		
	}
	
	@Test
	public void getPrimeListJSONTest() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/primes/11").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"Initial\":11,\"Primes\":[2,3,5,7,11]}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
		
	}
	
	
	@Test
	public void getPrimeListXMLTest() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/primes/10").accept(
				MediaType.APPLICATION_XML);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "<PrimeList><Initial>10</Initial><Primes><Primes>2</Primes><Primes>3</Primes><Primes>5</Primes><Primes>7</Primes></Primes></PrimeList>";
		
		//To test expected response scenarios	
		assertEquals(expected, result.getResponse().getContentAsString());	
		
		
		String unExpected = "<PrimeList><Initial>10</Initial><Primes><Primes>2</Primes><Primes>3</Primes><Primes>5</Primes><Primes>7</Primes><Primes>10</Primes></Primes></PrimeList>";
		//To test unExpected response scenarios	
		assertNotEquals(unExpected, result.getResponse().getContentAsString());		

	}

}
