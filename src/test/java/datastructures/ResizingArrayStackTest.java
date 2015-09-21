package datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import arsenal.datastructures.ResizingArrayStack;

public class ResizingArrayStackTest {

	private static Logger logger = LoggerFactory.getLogger(ResizingArrayStack.class);

	private ResizingArrayStack<String> stack = new ResizingArrayStack<String>(20);

	@Before
	public void setup() {
		logger.info("setting up ResizingArrayStackTest");
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