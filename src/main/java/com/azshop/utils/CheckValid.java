package com.azshop.utils;

public class CheckValid {
	public static boolean isValidPhoneNumber(String phoneNumber) {
	    String regex = "^[0-9]{10}$"; 
	    return phoneNumber.matches(regex);
	}
}
