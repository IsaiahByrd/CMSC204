
/**
 * This class contains the test case methods that students must implement
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {

	public MyQueue<String> stringQ;
	public MyStack<String> stringS;
	
	@BeforeEach
	void setUp() throws Exception {
		stringQ = new MyQueue<String>(3);
		stringQ.enqueue("a");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsEmpty() {
		assertEquals(false, stringQ.isEmpty());
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	void testDequeue() {
		try {
			assertEquals("a", stringQ.dequeue());
			 
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
		catch (QueueUnderflowException e){
			assertTrue(true, "This should have caused an QueueUnderflowException");
		}
		catch (Exception e){
			assertTrue(false, "This should have caused an QueueUnderflowException");
		}
	}

	@Test
	void testSize() {
		assertEquals(1, stringQ.size());
	}

	@Test
	void testEnqueue() {
		MyQueue<String> queue = new MyQueue<>(3);
        queue.enqueue("A");
       
        assertEquals("A, ", queue.toString(", "));
	}

	@Test
	void testIsFull() {
		MyQueue<String> queue = new MyQueue<>(3);
        assertFalse(queue.isFull());
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertTrue(queue.isFull());
	}

	@Test
	void testToString() {
		MyQueue<String> queue = new MyQueue<>(3);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals("A, B, C, ", queue.toString(", "));
	}

	@Test
	void testToStringString() {
		MyQueue<String> queue = new MyQueue<>(3);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals("A, B, C, ", queue.toString(", "));
	}

	@Test
	void testFill() {
		MyQueue<String> queue = new MyQueue<>(3);
		ArrayList<String> list = new ArrayList<>(3);
        queue.enqueue("A");
        queue.enqueue("B");
        
        list.add("C");
        list.add("C");
   
        
        queue.fill(list);
        assertEquals("C, C, ", queue.toString(", "));
	}

}
