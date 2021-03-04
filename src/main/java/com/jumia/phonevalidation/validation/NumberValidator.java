package com.jumia.phonevalidation.validation;

import java.util.function.Function;
import java.util.regex.*;


public enum NumberValidator {
	CAMEROON("Cameroon", (number) -> checkValidForCameroon(number)), ETHIOPIA("Ethiopia", (number) -> checkValidForEthiopia(number)),
	MOROCCO("Morocco", (number) -> checkValidForMorocco(number)), MOZAMBIQUE("Mozambique", (number) -> checkValidForMozambique(number)),
	UGANDA("Uganda", (number) -> checkValidForUganda(number)), NOT_VALID("Not valid Data", (number) -> false);

	private String country;
	private Function<String,Boolean> validationCountryFunction;

	public String getCountry() {
		return country;
	}

	public Function<String,Boolean> getValidationCountryFunction() {
		return validationCountryFunction;
	}

	static boolean checkValidForUganda(String number) {
		String regex = "\\(256\\)\\ ?\\d{9}$";
		  return checkValid(number, regex);
	}

	static boolean checkValidForMozambique(String number) {
		String regex = " \\(258\\)\\ ?[28]\\d{7,8}$";
		  return checkValid(number, regex);
	}

	static boolean checkValidForMorocco(String number) {
		String regex = "\\(212\\)\\ ?[5-9]\\d{8}$";
		  return checkValid(number, regex);
	}

	static boolean checkValidForEthiopia(String number) {
		String regex = "\\(251\\)\\ ?[1-59]\\d{8}$";
		  return checkValid(number, regex);
	}

	static boolean checkValidForCameroon(String number) {
		String regex = "\\(237\\)\\ ?[2368]\\d{7,8}$";
		  return checkValid(number, regex);
	}

	private static boolean checkValid(String number, String regex) {
		Pattern p = Pattern.compile(regex); 
		  Matcher m = p.matcher(number); 
		  
		return m.matches();
	}

	NumberValidator(String country, Function<String,Boolean> validationCountryFunction) {
		this.country = country;
		this.validationCountryFunction = validationCountryFunction;
	}
	
	
// need to be function and get number 
	public static boolean fromCode(String country, String number) {
		for (NumberValidator numberValidator : NumberValidator.values()) {
			if (numberValidator.getCountry().equalsIgnoreCase(country)) {
				return numberValidator.getValidationCountryFunction().apply(number);
			}
		}
		return NumberValidator.NOT_VALID.getValidationCountryFunction().apply(number);
	}

}
