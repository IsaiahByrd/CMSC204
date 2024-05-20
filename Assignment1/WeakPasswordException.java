
/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:Exception thrown when password contains between 6-10 characters
Due: 02/05/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/
public class WeakPasswordException extends RuntimeException {

	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}
}
