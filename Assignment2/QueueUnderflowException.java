/*
Class: CMSC204
Instructor: Farnaz Eivazi
Description:Exception thrown when the queue is empty
Due: 02/25/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rodney Coit
*/
public class QueueUnderflowException extends RuntimeException {

	public QueueUnderflowException() {
		super("Queue is empty");
	}
	
	public QueueUnderflowException(String msg) {
		super(msg);
	}
}
