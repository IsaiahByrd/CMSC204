/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:Exception thrown when the an element is added to a full queue
Due: 02/25/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/
public class QueueOverflowException extends RuntimeException {

	public QueueOverflowException() {
		super("Queue is full");
	}
	
	public QueueOverflowException(String msg) {
		super(msg);
	}
}
