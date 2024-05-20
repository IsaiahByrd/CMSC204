
/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEvaluatePostfixExpression() {
        try {
            // Test case: Simple postfix expression
            assertEquals(5.0, Notation.evaluatePostfixExpression("23+"), 0.001);

            // Test case: Postfix expression with more operands and operators
            assertEquals(2.5, Notation.evaluatePostfixExpression("35*42+/"), 0.001);

        
        } catch (InvalidNotationFormatException e) {
            fail("Unexpected InvalidNotationFormatException");
        }
    }

	@Test
	void testConvertPostfixToInfix() {
		try {
            // Test case: Simple postfix expression
            assertEquals("(2+3)", Notation.convertPostfixToInfix("23+"));

            // Test case: Postfix expression with more operands and operators
            assertEquals("((3*5)/(4+2))", Notation.convertPostfixToInfix("35*42+/"));

            // Add more test cases based on your implementation
        } catch (InvalidNotationFormatException e) {
            fail("Unexpected InvalidNotationFormatException");
        }
	}

	@Test
	void testConvertInfixToPostfix() {
		try {
            // Test case: Simple infix expression
            assertEquals("23+", Notation.convertInfixToPostfix("2+3"));

            // Test case: Infix expression with more operands and operators
            assertEquals("35*42/+", Notation.convertInfixToPostfix("(3*5)+(4/2)"));

            // Add more test cases based on your implementation
        } catch (InvalidNotationFormatException e) {
            fail("Unexpected InvalidNotationFormatException");
        }
	}

}
