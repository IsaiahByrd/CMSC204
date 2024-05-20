
/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:Exception thrown when the password contains 3 or more of the same character in a row
Due: 02/05/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/

public class InvalidSequenceException extends RuntimeException {

	public InvalidSequenceException() {
		super(" The password cannot contain more than two of the same character in sequence.");
	}
}
