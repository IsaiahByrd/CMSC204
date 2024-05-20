import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface {

	//fields
	private ArrayList<T> queue = new ArrayList<T>();
	private int max;
	private int numOfEntries;
	
	
	//default constructor
	public MyQueue() {
		this.max = 10;
		this.numOfEntries = 0;
		
	}
	
	//constructor with parameter
	public MyQueue(int size) {
		this.max = size;
		this.numOfEntries = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return this.queue.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.queue.size() >= max;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T temp = queue.get(0);
		queue.remove(0);
		numOfEntries--;
		return temp;
	}

	@Override
	public int size() {
		return this.queue.size();
	}

	

	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		
		for(T element : queue) {
			sb.append(element).append(delimiter);
		}
		
		return sb.toString();
	}
	

	@Override
	public void fill(ArrayList list) throws QueueOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		
		for (int i = 0; i < queue.size(); i++) {
			queue.set(i, (T) list.get(i));
		}
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		
		queue.add((T) e);
		numOfEntries++;
		return true;
	}

	
}
