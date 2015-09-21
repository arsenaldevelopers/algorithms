package datastructures;

import org.junit.Test;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class LinkedListStackTest {

	private static Logger logger = LoggerFactory.getLogger(LinkedListStackTest.class);

	private LinkedListStack<String> stack = new LinkedListStack<String>();

	@Before
	public void setup() {
		logger.info("setting up LinkedListStackTest");
	}

	@Test
	public void push10TimesAndPop10Times() {
		for(int i = 1; i <= 10; i++) {
			stack.push("item_" + i );
		}

		for(int i = 10; i >= 1; i-- ) {
			String item = stack.pop();
			assertEquals("item_" + i , item);
		}
	}

	@Test(expected=RuntimeException.class)
	public void expectExceptionWhenPopOnEmptyStack() {
		stack.pop();
	}

	@Test
	public void expectResizingWhenPushOnFullStack() {
		for(int i = 1; i <= 20; i++) {
			stack.push("item_" + i );
		}
		//stack is already full. expect resizing.
		stack.push("item_21");
		assertEquals("item_21", stack.pop());

		for(int i = 20; i >= 1; i-- ) {
			String item = stack.pop();
			assertEquals("item_" + i , item);
		}
	}

}