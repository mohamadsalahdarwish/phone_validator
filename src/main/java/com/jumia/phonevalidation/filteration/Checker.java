package com.jumia.phonevalidation.filteration;

import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.shared.Constants;
import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;


@Service
public class Checker {
	public boolean checkCountryFilteration(InMemorySearchRequest inMemorySearchRequest) {
		return inMemorySearchRequest.getCriteria().equalsIgnoreCase(Constants.COUNTRY_FILTER);
	}
	
	public boolean checkStateFilteration(InMemorySearchRequest inMemorySearchRequest) {
		return inMemorySearchRequest.getCriteria().equalsIgnoreCase(Constants.STATE_FILTER);
	}
}
