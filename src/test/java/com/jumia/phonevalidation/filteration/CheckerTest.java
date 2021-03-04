package com.jumia.phonevalidation.filteration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;

public class CheckerTest {

	@Test
	public void testCheckCountryFilteration() {
		Checker checker = new Checker();
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		inMemorySearchRequest.setCriteria("country");
		assertTrue(checker.checkCountryFilteration(inMemorySearchRequest));
	}

	@Test
	public void testCheckStateFilteration() {
		Checker checker = new Checker();
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		inMemorySearchRequest.setCriteria("state");
		assertTrue(checker.checkStateFilteration(inMemorySearchRequest));
	}

}
