package com.jumia.phonevalidation.validation;

import java.util.function.Supplier;

public enum CountryRetrieval {
	CAMEROON("(237)", () -> "Cameroon"), ETHIOPIA("(251)", () -> "Ethiopia"), MOROCCO("(212)", () -> "Morocco"),
	MOZAMBIQUE("(258)", () -> "Mozambique"), UGANDA("(256)", () -> "Uganda"), NOT_VALID("", () -> "Not valid Data");
	
	private String code;
	private Supplier<String> countrySupplier;

	public String getCode() {
		return code;
	}

	public Supplier<String> getCountrySupplier() {
		return countrySupplier;
	}

	CountryRetrieval(String code, Supplier<String> countrySupplier) {
		this.code = code;
		this.countrySupplier = countrySupplier;
	}
	
	public static String fromCode(String code) {
		for(CountryRetrieval countryRetrieval: CountryRetrieval.values()) {
			if(countryRetrieval.getCode().equalsIgnoreCase(code)) {
				return countryRetrieval.getCountrySupplier().get();
			}
		}
		return CountryRetrieval.NOT_VALID.getCountrySupplier().get();
	}

}
