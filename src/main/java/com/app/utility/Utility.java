package com.app.utility;

public class Utility {

	public static final int EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH, PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH;
	public static final String SYMBOL_ONE, SYMBOL_TWO;

	static {
		EMAIL_MIN_LENGTH = 9;
		EMAIL_MAX_LENGTH = 50;
		PASSWORD_MIN_LENGTH = 6;
		PASSWORD_MAX_LENGTH = 20;
		SYMBOL_ONE = "@";
		SYMBOL_TWO = ".com";

	}

	public static boolean validateEmail(String email) {
		if (!(email.length() > EMAIL_MIN_LENGTH && email.length() < EMAIL_MAX_LENGTH && email.contains(SYMBOL_ONE)
				&& email.endsWith(SYMBOL_TWO))) {
			return false;

		}
		return true;
	}

	

	public static boolean ValidatePassword(String password) {
		if (password.length() < PASSWORD_MIN_LENGTH || password.length() > PASSWORD_MAX_LENGTH)
			return false;
		else if (!password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})"))
			return false;

		return true;
	}
	
	public static boolean validateDateOfBirth(String dob) {
		int year=Integer.parseInt(dob.substring(0,4));
		System.out.println(year);
		if(year > 2010)
			return false;
		return true;
	}
	
	public static boolean checkEmailSuccess(String email) {
		
		return true;
	}

}
