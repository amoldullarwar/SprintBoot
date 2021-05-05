package com.base.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.base.demo.service.PrimeNumberService;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PrimeNumberServiceImplTest {

    @Autowired
    public PrimeNumberService primeNumberService;

    @Test
    public void testFindPrimeNos(){
    	assertThat(primeNumberService.findPrimNumUpto(0))
        .hasSameElementsAs(IntStream.of().boxed().collect(Collectors.toList()));
    	
    	assertThat(primeNumberService.findPrimNumUpto(2))
        .hasSameElementsAs(IntStream.of(2).boxed().collect(Collectors.toList()));
    	
        assertThat(primeNumberService.findPrimNumUpto(10))
                .hasSameElementsAs(IntStream.of(2, 3, 5, 7).boxed().collect(Collectors.toList()));
        
        assertThat(primeNumberService.findPrimNumUpto(11))
                .hasSameElementsAs(IntStream.of(2, 3, 5, 7, 11).boxed().collect(Collectors.toList()));
        
        assertThat(primeNumberService.findPrimNumUpto(50))
                .hasSameElementsAs(IntStream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47).boxed().collect(Collectors.toList()));
    }
}
