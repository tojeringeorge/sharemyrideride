package com.sharemyride.service;

public interface ValidtionSevice {
	boolean StringOnlyValidation(String value);
	boolean dateFormatValidation(String date);
	boolean numberFormatValidation(String number);
	boolean genderValidtion(String gender);
	boolean emptyNullValidation(String value);
	boolean emailFormatValidation(String email);
	boolean decimalFormatValidation(String decimal);
}
