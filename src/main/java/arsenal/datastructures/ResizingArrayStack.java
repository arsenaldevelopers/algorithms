package arsenal.datastructures;

import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResizingArrayStack<Item> implements Iterable<Item>{

	private static Logger logger = LoggerFactory.getLogger(ResizingArrayStack.class);

	private Item[] items;
	private int N;

	public ResizingArrayStack(int N) {
		this.items = (Item[])new Object[N];
	}

	public boolean isEmpty(){
		return N == 0;
	}

	public int size() {
		return N ;
	}

	public Item pop() {
		if(N == 0) {
			throw new RuntimeException("Stack is empty");
		}
		
		Item i = items[--N];
		items[N] = null;
		if(N <= items.length/4) { //resize array
			resize(items.length/2);
		}
		logger.info("Item poped : {}", i);
		return i;
	}

	public void push(Item item) {
		logger.info("Item pushed : {}", item);
		if(N  == items.length) {
			resize(2*items.length);
		}
		items[N++] = item;
	}


	private void resize(int max) {
		logger.info("resizing array from size : {} to : {}", items.length, max);
		//moves items from array into a new array of size max >= N
		Item[] resizedItems = (Item[])new Object[max];
		for(int i = 0; i < N; i++) {
			resizedItems[i] = items[i];
		}
		items = resizedItems;
	}


	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		public boolean hasNext(){
			return i > 0;
		}

		public Item next() {
			return items[--i];
		}

		public void remove() {
			
		}

	}



}