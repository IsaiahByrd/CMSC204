
/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:Exception thrown when the length of the password is less than 6 characters
Due: 02/05/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/
public class LengthException extends RuntimeException {

	public LengthException() {
		super(" The password must be at least 6 characters long");
	}
}
