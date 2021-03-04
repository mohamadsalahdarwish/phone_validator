package com.jumia.phonevalidation.filteration;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;


public class StateFilterTest {

	@InjectMocks
	StateFilter stateFilter;
	@Mock
	DataFilter dataFilter;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetPhoneList() {
		Map<String ,List<Phone>> phonesMap = new LinkedHashMap<>();
		List<Phone> validPhonesList = new ArrayList<>();
		List<Phone> unValidPhonesList = new ArrayList<>();

		validPhonesList.add(Phone.builder().country("xyz").name("msd").state("valid").build());
		validPhonesList.add(Phone.builder().country("xyz1").name("msd1").state("valid").build());
		validPhonesList.add(Phone.builder().country("xyz1").name("msd1").state("valid").build());
		unValidPhonesList.add(Phone.builder().country("xyz").name("msd").state("unvalid").build());
		phonesMap.put("valid", validPhonesList);
		phonesMap.put("unvalid", unValidPhonesList);

		Mockito.when(dataFilter.groupByValidaty( Mockito.any())).thenReturn(phonesMap);
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		inMemorySearchRequest.setCriteria("state");
		inMemorySearchRequest.setField("valid");
		List<Phone> inputPhones = new ArrayList<>();
		List<Phone> phoneList = stateFilter.getPhoneList(inMemorySearchRequest , inputPhones);
		assertNotNull(phoneList);
		
	}

}
