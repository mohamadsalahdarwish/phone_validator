package com.jumia.phonevalidation.ui.model.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneGridResponse {
	private int  totalPages;
	private long totalElements;
	private List<Phone> phones = new ArrayList<>();
}
