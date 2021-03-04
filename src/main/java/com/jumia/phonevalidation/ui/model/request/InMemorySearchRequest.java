package com.jumia.phonevalidation.ui.model.request;

import lombok.Data;

@Data
public class InMemorySearchRequest {
	private String field;
	private String criteria;
	private int pageNo;
}
