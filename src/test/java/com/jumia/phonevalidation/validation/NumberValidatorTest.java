package com.jumia.phonevalidation.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberValidatorTest {

	@Test
	public void testCheckValidForUganda() {
		assertTrue(NumberValidator.UGANDA.getValidationCountryFunction().apply("(256) 714660221"));
	}

	@Test
	public void testCheckValidForMozambique() {
		assertFalse(NumberValidator.MOZAMBIQUE.getValidationCountryFunction().apply("(258) 84330678235"));
	}

	@Test
	public void testCheckValidForMorocco() {
		assertFalse(NumberValidator.MOROCCO.getValidationCountryFunction().apply("(212) 6007989253"));
	}

	@Test
	public void testCheckValidForEthiopia() {
		assertFalse(NumberValidator.ETHIOPIA.getValidationCountryFunction().apply("(251) 9773199405"));
	}

	@Test
	public void testCheckValidForCameroon() {
		assertTrue(NumberValidator.CAMEROON.getValidationCountryFunction().apply("(237) 699209115"));
	}

	@Test
	public void testFromCode() {
		assertTrue(NumberValidator.fromCode("Cameroon", "(237) 699209115"));
		
	}

}
