
/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:Exception thrown when password does not contain a digit
Due: 02/05/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/
public class NoDigitException extends RuntimeException {

	public NoDigitException() {
		super(" The password must contain at least one digit");
	}
}
