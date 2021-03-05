package com.jumia.phonevalidation.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountryRetrievalTest {

	@Test
	public void testFromCode() {
		assertEquals("Cameroon",CountryRetrieval.fromCode("(237)"));
	}

}
