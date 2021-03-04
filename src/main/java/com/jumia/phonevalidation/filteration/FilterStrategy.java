package com.jumia.phonevalidation.filteration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;

@Service
public class FilterStrategy {
	
	private AbstractFilter abstractFilter;
	
	@Autowired
	public void setAbstractFilter(AbstractFilter abstractFilter) {
		this.abstractFilter = abstractFilter;
	}
	
	public List<Phone> getData(InMemorySearchRequest inMemorySearchRequest, List<Phone> inputPhones){
		return abstractFilter.getPhoneList(inMemorySearchRequest, inputPhones);
	}
}
