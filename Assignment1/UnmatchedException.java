
/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:Exception thrown when password and re-typed password do not match
Due: 02/05/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/
public class UnmatchedException extends RuntimeException {
	
	public UnmatchedException() {
		super("Passwords do not match");
	}
}
