package com.jumia.phonevalidation.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InMemorySearchRequest {
	private String field;
	private String criteria;
	private int pageNo;
}
