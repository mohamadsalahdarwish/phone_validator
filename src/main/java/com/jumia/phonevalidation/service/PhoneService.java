package com.jumia.phonevalidation.service;

import com.jumia.phonevalidation.ui.model.request.InMemorySearchRequest;
import com.jumia.phonevalidation.ui.model.response.PhoneGridResponse;

public interface PhoneService {
	PhoneGridResponse getPhoneList(int pageNo);
	PhoneGridResponse  filterPhoneListByField(InMemorySearchRequest phoneListRequest);
}
