package com.jumia.phonevalidation.ui.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Phone {
	private String name;
	private String country;
	private String state;
	private String countryCode;
	private String number;


	
}
