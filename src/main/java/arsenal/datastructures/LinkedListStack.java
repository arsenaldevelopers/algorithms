package arsenal.datastructures;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListStack<Item> implements Iterable<Item> {

	private static Logger logger = LoggerFactory.getLogger(LinkedListStack.class);
	private Node<Item> top;
	private long N;


	public void push(Item item) {
		//construct a new Node object
		Node<Item> new_node = new Node<Item>();
		new_node.item = item;
		new_node.next = top;
		top = new_node;
		N++;
	}

	public Item pop(){
		if(top == null) {
			throw new RuntimeException("Stack if empty..");
		}
		Node<Item> current_top = top;
		top = top.next;
		N--;
		return current_top.item;
	}


	private static class Node<Item> {
		Node<Item> next;
		Item item;
	}


	public Iterator<Item> iterator() {
		return null;
	}
}