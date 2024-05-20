/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:This exception occurs when a Notation format is incorrect.
Due: 02/25/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/
public class InvalidNotationFormatException extends RuntimeException {

	public InvalidNotationFormatException() {
		super("Notation format is incorrect");
	}
	
	public InvalidNotationFormatException(String msg) {
		super(msg);
	}
}
