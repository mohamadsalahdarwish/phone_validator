package com.jumia.phonevalidation.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.jumia.phonevalidation.exceptions.model.PhoneValidatorServiceException;
import com.jumia.phonevalidation.filteration.FilterFactory;
import com.jumia.phonevalidation.io.entity.Customer;
import com.jumia.phonevalidation.io.repository.CustomerRepository;
import com.jumia.phonevalidation.shared.Util;
import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;
import com.jumia.phonevalidation.ui.model.response.PhoneGridResponse;

public class PhoneServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@Mock
	FilterFactory filterFactory;

	@Mock
	Util util;

	@InjectMocks
	PhoneServiceImpl phoneServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetPhoneList() {
		List<Customer> customers = new ArrayList<>();
		Customer customer = Customer.builder().id(1).name("Mohammad").phone("(256) 714660221").build();
		customers.add(customer);
		Page<Customer> pagedResult = new PageImpl<Customer>(customers);
		Mockito.when(customerRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(pagedResult);
		PhoneGridResponse returnedPhonesResponse = phoneServiceImpl.getPhoneList(1);
		assertEquals(1, returnedPhonesResponse.getTotalPages());
	}

	@Test(expected = PhoneValidatorServiceException.class)
	public void testGetPhoneList_NoData() {
		List<Customer> customers = new ArrayList<>();
		Page<Customer> pagedResult = new PageImpl<Customer>(customers);
		Mockito.when(customerRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(pagedResult);
		phoneServiceImpl.getPhoneList(1);

	}

	@Test
	public void testFilterPhoneListByField() {
		List<Phone> phones = new ArrayList<>();
		phones.add(Phone.builder().country("xyz").name("msd").state("valid").build());
		List<Customer> customers = new ArrayList<>();
		InMemorySearchRequest inMemorySearchRequest = InMemorySearchRequest.builder().criteria("state").field("valid").build();
		Mockito.when(filterFactory.getFilteredPhoneList(Mockito.any(), Mockito.any())).thenReturn(phones);
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		Mockito.when(util.paginateGridData(Mockito.anyList(), Mockito.anyInt(), Mockito.anyInt(), Mockito.any(StringBuilder.class))).thenReturn(phones);
		PhoneGridResponse returnedPhonesResponse = phoneServiceImpl.filterPhoneListByField(inMemorySearchRequest);
		assertEquals(1,returnedPhonesResponse.getPhones().size());
		
	}

	@Test(expected = PhoneValidatorServiceException.class)
	public void testFilterPhoneListByField_NoData() {
		List<Phone> phones = new ArrayList<>();
		List<Customer> customers = new ArrayList<>();
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		Mockito.when(filterFactory.getFilteredPhoneList(Mockito.any(), Mockito.any())).thenReturn(phones);
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		phoneServiceImpl.filterPhoneListByField(inMemorySearchRequest);
	}

}
