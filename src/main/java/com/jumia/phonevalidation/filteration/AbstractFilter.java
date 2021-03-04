package com.jumia.phonevalidation.filteration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;


@Service
public interface AbstractFilter {
	List<Phone> getPhoneList(InMemorySearchRequest inMemorySearchRequest, List<Phone> inputPhones);
}
