package com.jumia.phonevalidation.filteration;

import static org.junit.Assert.*;

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

public class CountryFilterTest {

	@InjectMocks
	CountryFilter countryFilter;
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
		List<Phone> xyzPhonesList = new ArrayList<>();
		List<Phone> xyz1PhonesList = new ArrayList<>();

		xyzPhonesList.add(Phone.builder().country("xyz").name("msd").build());
		xyz1PhonesList.add(Phone.builder().country("xyz1").name("msd1").build());
		xyz1PhonesList.add(Phone.builder().country("xyz1").name("msd1").build());
		xyzPhonesList.add(Phone.builder().country("xyz").name("msd").build());
		phonesMap.put("xyz", xyzPhonesList);
		phonesMap.put("xyz1", xyz1PhonesList);

		Mockito.when(dataFilter.groupByCountry( Mockito.any())).thenReturn(phonesMap);
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		inMemorySearchRequest.setCriteria("country");
		inMemorySearchRequest.setField("xyz");
		List<Phone> inputPhones = new ArrayList<>();
		List<Phone> phoneList = countryFilter.getPhoneList(inMemorySearchRequest , inputPhones);
		assertNotNull(phoneList);
		
	}
}
