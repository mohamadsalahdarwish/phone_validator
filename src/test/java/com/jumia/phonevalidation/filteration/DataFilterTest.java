package com.jumia.phonevalidation.filteration;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jumia.phonevalidation.ui.model.response.Phone;

public class DataFilterTest {

	@Test
	public void testGroupByCountry() {
		DataFilter dataFilter = new DataFilter();
		List<Phone> phoneList = new ArrayList<>();
		phoneList.add(Phone.builder().country("xyz").name("msd").build());
		phoneList.add(Phone.builder().country("xyz1").name("msd1").build());
		phoneList.add(Phone.builder().country("xyz1").name("msd1").build());
		phoneList.add(Phone.builder().country("xyz").name("msd").build());
		Map<String, List<Phone>> value = dataFilter.groupByCountry(phoneList );
		assertTrue(value.size() >1);
	}

	@Test
	public void testGroupByValidaty() {
		DataFilter dataFilter = new DataFilter();
		List<Phone> phoneList = new ArrayList<>();
		phoneList.add(Phone.builder().country("xyz").name("msd").state("valid").build());
		phoneList.add(Phone.builder().country("xyz1").name("msd1").state("valid").build());
		phoneList.add(Phone.builder().country("xyz1").name("msd1").state("valid").build());
		phoneList.add(Phone.builder().country("xyz").name("msd").state("unvalid").build());
		Map<String, List<Phone>> value = dataFilter.groupByValidaty(phoneList );
		assertTrue(value.size() >1);
	}

}
