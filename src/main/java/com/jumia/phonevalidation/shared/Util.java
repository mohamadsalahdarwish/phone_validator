package com.jumia.phonevalidation.shared;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.jumia.phonevalidation.ui.model.response.Phone;

@Service
public class Util {

	// divide the list in memory based on page size
	public List<Phone> paginateGridData(List<Phone> phones,
			int page, int pageSize, StringBuilder totalPages) {
		List<List<Phone>> subLists = Lists.partition(phones, pageSize);
		totalPages.append(subLists.size());
		return (subLists != null && !subLists.isEmpty() ? subLists.get(page-1) : null);
	}
}
