import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T> {

	//fields
	private ArrayList<T> stack = new ArrayList<T>();
	private int max;
	private int numOfEntries;

	
	//constructor
	public MyStack() {
		this.max = 10;
		this.numOfEntries = 0;
	}
	
	//constructor with parameter
	public MyStack(int size) {
		this.max = size;
		this.numOfEntries = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return this.stack.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.stack.size() >= max;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}
		
		numOfEntries--;
		return this.stack.remove(this.stack.size() - 1);
	}

	@Override
	public T top() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}
		
		return stack.get(stack.size() - 1);
	}

	@Override
	public int size() {
		return this.stack.size();
	}

	
	//add item to stack
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(this.isFull()) {
			throw new StackOverflowException();
		}
		
		numOfEntries++;
		return this.stack.add(e);
	}

	@Override
	public String toString(String delimiter) {
		StringBuilder sb = new StringBuilder();
		
		for(T element : stack) {
			sb.append(element).append(delimiter);
		}
		
		return sb.toString();
	}

	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		
		for (int i = 0; i < stack.size(); i++) {
			stack.set(i, list.get(i));
		}
	}

}
