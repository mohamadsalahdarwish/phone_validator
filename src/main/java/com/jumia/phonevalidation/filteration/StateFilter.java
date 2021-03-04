package com.jumia.phonevalidation.filteration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;

@Service
@Qualifier("StateFilter")
public class StateFilter implements AbstractFilter{
	@Autowired
	DataFilter dataFilter;

	@Override
	public List<Phone> getPhoneList(InMemorySearchRequest inMemorySearchRequest, List<Phone> inputPhones) {
		return dataFilter.groupByValidaty(inputPhones).get(inMemorySearchRequest.getField());
	}
}
