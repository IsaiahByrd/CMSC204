
/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {
	
	public MyStack<String> stringS;

	@BeforeEach
	void setUp() throws Exception {
		stringS = new MyStack<String>(2);
		stringS.push("a");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsEmpty() {
		assertEquals(false, stringS.isEmpty());
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	void testIsFull() {
		stringS.push("b");
		assertTrue(stringS.isFull());
	}

	@Test
	void testPop() {
		assertEquals(false, stringS.isEmpty());
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	void testTop() {
		assertEquals("a", stringS.top());
	}

	@Test
	void testSize() {
		assertEquals(1, stringS.size());
	}

	@Test
	void testPush() {
		stringS.push("b");
		assertEquals("b", stringS.top());
	}

	@Test
	void testToString() {
		stringS.push("b");
	
        assertEquals("a, b, ", stringS.toString(", "));
	}

	@Test
	void testToStringString() {
		stringS.push("b");
		
        assertEquals("a, b, ", stringS.toString(", "));
	}

	@Test
	void testFill() {
		
		
		ArrayList<String> list = new ArrayList<>(3);
		
		 list.add("C");
	
	     
	     stringS.fill(list);
	     assertEquals("C, ", stringS.toString(", "));
	}

}
