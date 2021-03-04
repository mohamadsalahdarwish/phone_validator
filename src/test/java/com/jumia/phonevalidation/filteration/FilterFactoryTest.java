package com.jumia.phonevalidation.filteration;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;

public class FilterFactoryTest {

	
	
	@InjectMocks
	FilterFactory filterFactory;

	@Mock
	private CountryFilter countryFilter;

	@Mock
	private StateFilter stateFilter;

	@Mock
	FilterStrategy filterStrategy;
	
	@Mock
	Checker checker;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCountryFilter() {
		List<Phone> phones = new ArrayList<>();
		Mockito.when(filterStrategy.getData(Mockito.any(), Mockito.any()))
				.thenReturn(phones);
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		List<Phone> inputPhones = new ArrayList<Phone>();
		List<Phone> returnedPhones = filterFactory.filterByCountry(inMemorySearchRequest, inputPhones);
		assertNotNull(returnedPhones);
	}
	
	@Test
	public void testStateFilter() {
		List<Phone> phones = new ArrayList<>();
		Mockito.when(filterStrategy.getData(Mockito.any(), Mockito.any()))
				.thenReturn(phones);
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		List<Phone> inputPhones = new ArrayList<Phone>();
		List<Phone> returnedPhones = filterFactory.filterByState(inMemorySearchRequest, inputPhones);
		assertNotNull(returnedPhones);
	}

}
