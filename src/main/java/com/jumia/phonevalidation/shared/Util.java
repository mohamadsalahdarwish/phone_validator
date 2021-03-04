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
		if (page == 0 && pageSize == 0)
			return phones;
		if (page > 0)
			page = page - 1;
		int totalPagesInt = 0;
		if (phones.size() % pageSize == 0) {
			totalPagesInt = (phones.size() / pageSize);
		} else {
			totalPagesInt = (phones.size() / pageSize) + 1;
		}

		totalPages.append(totalPagesInt);

		List<List<Phone>> subSets = Lists.partition(phones, pageSize);

		return (subSets != null && !subSets.isEmpty() ? subSets.get(page) : null);
	}
}
