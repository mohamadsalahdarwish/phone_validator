package com.jumia.phonevalidation.filteration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;

@Service
@Qualifier("CountryFilter")
@Primary
public class CountryFilter implements AbstractFilter{
	@Autowired
	DataFilter dataFilter;

	@Override
	public List<Phone> getPhoneList(InMemorySearchRequest inMemorySearchRequest, List<Phone> inputPhones) {
		return dataFilter.groupByCountry(inputPhones).get(inMemorySearchRequest.getField());
	}
	
}
