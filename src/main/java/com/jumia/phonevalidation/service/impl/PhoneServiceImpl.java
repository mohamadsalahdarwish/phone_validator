package com.jumia.phonevalidation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jumia.phonevalidation.exceptions.model.PhoneValidatorServiceException;
import com.jumia.phonevalidation.filteration.FilterFactory;
import com.jumia.phonevalidation.io.entity.Customer;
import com.jumia.phonevalidation.io.repository.CustomerRepository;
import com.jumia.phonevalidation.service.PhoneService;
import com.jumia.phonevalidation.shared.Constants;
import com.jumia.phonevalidation.shared.Util;
import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.ErrorMessages;
import com.jumia.phonevalidation.ui.model.response.Phone;
import com.jumia.phonevalidation.ui.model.response.PhoneGridResponse;
import com.jumia.phonevalidation.validation.CountryRetrieval;
import com.jumia.phonevalidation.validation.NumberValidator;


@Service
public class PhoneServiceImpl implements PhoneService{
	final Logger logger = LogManager.getLogger(PhoneServiceImpl.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	FilterFactory filterFactory;
	
	@Autowired
	Util util;

	@Override
	public PhoneGridResponse getPhoneList(int pageNo) {
		logger.info("Start function : {}","getPhoneList");
        Pageable paging = PageRequest.of(pageNo-1, Constants.PAGE_SIZE);
	     Page<Customer> pagedResult = customerRepository.findAll(paging);
	        if(pagedResult.hasContent()) {
	        	return PhoneGridResponse.builder().phones(convertToPhoneList(pagedResult.getContent()))
	        			.totalPages(pagedResult.getTotalPages()).build();
	        } else {
	        	throw new PhoneValidatorServiceException(ErrorMessages.NO_DATA_FOUND.getErrorMessage());
	        }
	}


	private List<Phone> convertToPhoneList(List<Customer> customerList) {
		logger.info("Start function : {}","convertToPhoneList");
		List<Phone> phoneList = new ArrayList<>();
		customerList.stream().forEach(c->{
			String code = c.getPhone().split("\\s+")[0];
			String retrievedCountry = CountryRetrieval.fromCode(code);
			Phone phone = Phone.builder().name(c.getName()).country(retrievedCountry)
					.countryCode(code.substring(1, code.length() - 1)).number(c.getPhone())
					.state(NumberValidator.fromCode(retrievedCountry, c.getPhone())?"valid":"unvalid").build();
			phoneList.add(phone);
		});
		return phoneList;
	}


	@Override
	public PhoneGridResponse filterPhoneListByField(InMemorySearchRequest inMemorySearchRequest) {
		logger.info("Start function : {}","filterPhoneListByField");
		List<Customer> customers =  new ArrayList<>();
		customerRepository.findAll().forEach(c -> customers.add(c));
		List<Phone>phones = filterFactory.getFilteredPhoneList(inMemorySearchRequest, convertToPhoneList(customers));
		if(phones.isEmpty()) throw new PhoneValidatorServiceException(ErrorMessages.NO_DATA_FOUND.getErrorMessage());
		StringBuilder totalPages = new StringBuilder();
		List<Phone>phonesPerPageRequest =util.paginateGridData(phones, inMemorySearchRequest.getPageNo(), Constants.PAGE_SIZE, totalPages);
		 return PhoneGridResponse.builder().phones(phonesPerPageRequest)
        			.totalPages(!String.valueOf(totalPages).equals("")?Integer.parseInt(String.valueOf(totalPages)):0).build();
	}
	
}
