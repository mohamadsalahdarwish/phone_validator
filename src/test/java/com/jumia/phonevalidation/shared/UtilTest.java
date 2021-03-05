package com.jumia.phonevalidation.shared;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jumia.phonevalidation.ui.model.response.Phone;

public class UtilTest {

	@Test
	public void testPaginateGridData() {
		List<Phone> phoneList = new ArrayList<>();
		phoneList.add(Phone.builder().country("xyz").name("msd").build());
		phoneList.add(Phone.builder().country("xyz1").name("msd1").build());
		phoneList.add(Phone.builder().country("xyz1").name("msd1").build());
		phoneList.add(Phone.builder().country("xyz").name("msd").build());
		StringBuilder totalPages = new StringBuilder();
		Util util = new Util();
		List<Phone>phones = util.paginateGridData(phoneList, 1, 2, totalPages);
		assertEquals(2, phones.size());
	}

}
