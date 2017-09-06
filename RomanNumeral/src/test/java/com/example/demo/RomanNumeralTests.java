package com.example.demo;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class RomanNumeralTests {

	RomanNumeral romanNumeral = new RomanNumeral();
	@Test
	public void testGet5(){
		assert romanNumeral.getRoman(5) == "V";

	}


	@Test
	public void testGetLowest(){
		Map.Entry<Integer, String> result = romanNumeral.findLowestRoman(15);
		assertEquals(10, result.getKey().intValue());
	}

	@Test
	public void testGetHighest(){
		Map.Entry<Integer, String> result = romanNumeral.findFirstHighestRoman(15);
		assertEquals(50, result.getKey().intValue());
	}


	@Test
	public void test3(){
		String roman = romanNumeral.getRoman(3);
		assertEquals("III",roman);
	}

	@Test
	public void test5(){
		String roman = romanNumeral.getRoman(5);
		assertEquals("V",roman);
	}

	@Test
	public void test6(){
		String roman = romanNumeral.getRoman(6);
		assertEquals("VI",roman);
	}

	@Test
	public void test9(){
		String roman = romanNumeral.getRoman(9);
		assertEquals("IX", roman);
	}

	@Test
	public void test15(){
		String roman = romanNumeral.getRoman(15);
		assertEquals("XV",roman);
	}

	@Test
	public void test16(){
		String roman = romanNumeral.getRoman(16);
		assertEquals("XVI",roman);
	}

	@Test
	public void test20(){
		String roman = romanNumeral.getRoman(20);
		assertEquals("XX",roman);
	}

	@Test
	public void test50(){
		String roman = romanNumeral.getRoman(50);
		assertEquals(roman,"L");
	}

	@Test
	public void test70(){
		String roman = romanNumeral.getRoman(70);
		assertEquals( roman,"LXX");
	}


	@Test
	public void test4(){
		String roman = romanNumeral.getRoman(4);
		assertEquals("IV", roman);
	}


	@Test
	public void test89(){
		String roman = romanNumeral.getRoman(89);
		assertEquals("LXXXIX", roman);
	}

	@Test
	public void test90(){
		String roman = romanNumeral.getRoman(90);
		assertEquals("XC", roman);
	}

	@Test
	public void test95(){
		String roman = romanNumeral.getRoman(95);
		assertEquals("XCV", roman);
	}

	@Test
	public void test209(){
		String roman = romanNumeral.getRoman(209);
		assertEquals("CCIX", roman);
	}

	@Test
	public void test388(){
		String roman = romanNumeral.getRoman(388);
		assertEquals("CCCLXXXVIII", roman);
	}

	@Test
	public void test489(){
		String roman = romanNumeral.getRoman(489);
		assertEquals("CDLXXXIX", roman);
	}

	@Test
	public void test999(){
		String roman = romanNumeral.getRoman(999);
		assertEquals("CMXCIX", roman);
	}

	@Test
	public void testGetKey(){
		assert 1 == romanNumeral.getKey("I");
	}

}
