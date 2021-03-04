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

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.Phone;

public class FilterStrategyTest {

	@InjectMocks
	FilterStrategy filterStrategy;
	
	@Mock
	AbstractFilter abstractFilter;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetData() {
		List<Phone> phones = new ArrayList<>();
		Mockito.when(abstractFilter.getPhoneList(Mockito.any(), Mockito.any())).thenReturn(phones);
		
		InMemorySearchRequest inMemorySearchRequest = new InMemorySearchRequest();
		List<Phone> inputPhones = new ArrayList<Phone>();
		List<Phone> returnedPhones = filterStrategy.getData(inMemorySearchRequest, inputPhones );
		assertNotNull(returnedPhones);
	}

}
