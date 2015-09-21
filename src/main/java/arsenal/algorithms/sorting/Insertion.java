package arsenal.algorithms.sorting;

import java.util.regex.Pattern;
import java.util.Scanner;

public class Insertion {

	private static final Pattern WHITESPACE = Pattern.compile("\\p{javaWhitespace}+");


	public static void sort(Comparable[] input) {
		if(input == null)
			throw new IllegalArgumentException();
		for (int i = 1; i < input.length ; i++ ) {
			for (int j = i; j > 0 && less(input[j], input[j-1]) ; j-- ) {
				exchange(input, j, j - 1);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static boolean less(Comparable<Comparable> a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public static void exchange(Comparable[] input, int i, int j) {
		if(input == null || i < 0 || i >= input.length || j < 0 || j >= input.length)
			throw new IllegalArgumentException();
		Comparable tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

	public static boolean isSorted(Comparable[] input) {
		if(input == null)
			throw new IllegalArgumentException();
		for (int i = 1; i < input.length ; i++ ) {
			if(less(input[i], input[i-1])) 
				return false;
		}
		return true;
	}

	public static void show(Comparable[] a) {
		if(a == null)
			throw new IllegalArgumentException();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner sysInput = new Scanner(System.in);
		String[] input = null;
		while(sysInput.hasNextLine()) {
			input = WHITESPACE.split(sysInput.nextLine());
		}
		show(input);
		sort(input);
		assert isSorted(input);
		show(input);
		
	}
}