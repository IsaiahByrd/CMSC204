import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description: Class that implements methods and exceptions to check if the user entered a valid password.
Due: 02/05/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/



public class PasswordCheckerUtility {

	
	
	//Constructor
	public PasswordCheckerUtility() {
		
	}
	
	
	/*
	 * Compare equality of two passwords
	 * Parameters: password - password string to be checked for
	passwordConfirm - passwordConfirm string to be checked against password for
	 * Throws:
		UnmatchedException - thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		if (!(password.equals(passwordConfirm))) {
			throw new UnmatchedException();
		}
	}
	
	
	/*
	 * Compare equality of two passwords
	Parameters:
	password - password string to be checked for
	passwordConfirm - passwordConfirm string to be checked against password for
	Returns:
	true if both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * Checks the password length requirement - The password must be at least 6 characters long
	Parameters:
	password - password string to be checked for length
	Returns:
	true if meets minimum length requirement
	Throws:
	LengthException - thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength​(String password) throws LengthException {
		if (password.length() < 6) {
			throw new LengthException();
		}
		else {
			return true;
		}
	}
	
	
	/*
	 *Checks the password alpha character requirement - Password must contain an uppercase alpha character
	Parameters:
	password - password string to be checked for alpha character requirement
	Returns:
	true if meet alpha character requirement
	Throws:
	NoUpperAlphaException - thrown if does not meet alpha character requirement 
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		
		boolean isUpper = false;
		
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			
			if (Character.isUpperCase(c)) {
				isUpper = true;
				
			}
			
		}
		if(!isUpper) {
			throw new NoUpperAlphaException();
		}
		else {
			return true;
		}
		
		
	}
	
	
	/*
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	Parameters:
	password - password string to be checked for lowercase requirement
	Returns:
	true if meets lowercase requirement
	Throws:
	NoLowerAlphaException - thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		
		boolean isLower = false;
		
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			
			if (Character.isLowerCase(c)) {
				isLower = true;
				
			}
			
		}
		if(!isLower) {
			throw new NoLowerAlphaException();
		}
		else {
			return true;
		}
	}
	
	
	/*
	 * Checks the password Digit requirement - Password must contain a numeric character
	Parameters:
	password - password string to be checked for Digit requirement
	Returns:
	true if meet Digit requirement
	Throws:
	NoDigitException - thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		
		boolean isDigit = false;
		
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			
			if (Character.isDigit(c)) {
				isDigit = true;
				
			}
			
		}
		
		if(!isDigit) {
			throw new NoDigitException();
		}
		else {
			return true;
		}
	}
	
	
	/*
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	Parameters:
	password - password string to be checked for SpecialCharacter requirement
	Returns:
	true if meets SpecialCharacter requirement
	Throws:
	NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {

       
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

        
        Matcher matcher = pattern.matcher(password);

       
        if (!matcher.matches()) {
            return true;
        } else {
            
            throw new NoSpecialCharacterException();
        }
    }
	
	
	/*
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	Parameters:
	password - password string to be checked for Sequence requirement
	Returns:
	false if does NOT meet Sequence requirement
	Throws:
	InvalidSequenceException - thrown if meets Sequence requirement
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		
		
		for (int i = 0; i < password.length(); i++) {
			
			char c = password.charAt(i);
			
			
			if (i > 1 && password.charAt(i - 1) == c && password.charAt(i - 2) == c) {
				
				throw new InvalidSequenceException();
			}
			
		}
		return false;
	}
	
	
	/*
	 * Return true if valid password (follows all the following rules), returns false if an invalid password 1. At least 6 characters long - 2.
	 *  At least 1 numeric character- 3. At least 1 uppercase alphabetic character - 4. At least 1 lowercase alphabetic character - 5. 
	 *  At least 1 special character - 6. No more than 2 of the same character in a sequence - Hello@123 – OK AAAbb@123 – not OK Aaabb@123 – OK
	Parameters:
	password - - string to be checked for validity
	Returns:
	true if valid password (follows all rules from above), false if an invalid password
	Throws:
	LengthException - thrown if length is less than 6 characters
	NoUpperAlphaException - thrown if no uppercase alphabetic
	NoLowerAlphaException - thrown if no lowercase alphabetic
	NoDigitException - thrown if no digit
	NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	InvalidSequenceException - thrown if more than 2 of same character.
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
    NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		try {
			isValidLength​(password);
			hasUpperAlpha(password);
			hasLowerAlpha(password);
			hasDigit(password);
			hasSpecialChar(password);
			NoSameCharInSequence(password);
			return true;
		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException |
				NoSpecialCharacterException | InvalidSequenceException e) {
			throw e; 
		} catch (Exception e) {
			return false;
		}
	}

	
	
	/*
	 * checks if the password contains 6 to 9 characters
	Parameters:
	password - password string to be checked for
	Returns:
	true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars​(String password) {
		
		if ((password.length() <= 9) && (password.length() >= 6)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	Parameters:
	password - string to be checked if weak password
	Returns:
	false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	Throws:
	WeakPasswordException - if length of password is between 6 and 9 (inclusive), ALTHOUGH the password may be VALID.
	 */
	public static boolean isWeakPassword​(String password) throws WeakPasswordException {
		
		if ((password.length() >= 6) && (password.length() <= 9)) {
			throw new WeakPasswordException();
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of any invalid passwords 
	 * (weak passwords are not considered invalid). The ArrayList of invalid passwords will be of the following format: password BLANK message of 
	 * the exception thrown
	Parameters:
	passwords - list of passwords
	Returns:
	ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords​(ArrayList<String> passwords) {
		
		
		ArrayList<String> invalid = new ArrayList<String>();
				
			
		passwords.forEach((password) -> {
			try {
				PasswordCheckerUtility.isValidPassword(password);
			} catch (RuntimeException e) {
				invalid.add(password + e.getMessage());
			}
		});
				
		
		return invalid;
	}
	
	
}
