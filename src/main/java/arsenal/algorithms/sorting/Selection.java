package arsenal.algorithms.sorting;

import java.util.regex.Pattern;

import utils.StdDraw;
import  utils.StdIn;
import utils.StdRandom;

public class Selection {

	// the default token separator; we maintain the invariant that this value 
    // is held by the scanner's delimiter between calls
    private static final Pattern WHITESPACE_PATTERN
        = Pattern.compile("\\p{javaWhitespace}+");


	public static void sort(Comparable[] a){
		if(a == null || a.length == 0) throw new IllegalArgumentException("Input is null");
		int len = a.length;

		for(int i = 0; i < len; i++) { // exchange
			int min = i;
			for(int j = i + 1; j < len; j++) { //find ith smallest element
				if(less(a[j], a[min])) min = j;
			}
			exchange(a, i, min);
		}
	}

	@SuppressWarnings("unchecked")
	public static boolean less(Comparable<Comparable> x, Comparable y) {
		return x.compareTo(y) < 0 ;
	}

	public static void exchange(Comparable[] a, int x, int y) {
		Comparable temp  = a[y];
		a[y] = a[x];
		a[x] = temp;
	}

	public static boolean isSorted(Comparable[] a) {
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}

	public static void show(Comparable[] a) {
		for(int i = 0; i < a.length; i++) {
			if(i%50 == 0) System.out.println();
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void showHistogram(Integer[] a, int yStep) {
		int N = a.length;
		StdDraw.setXscale(0, 1.5*N);
		StdDraw.setYscale(0, 1000);
		for (int i = 0; i < a.length; i++) {
			StdDraw.filledRectangle(.5 + i,  a[i] + yStep,  .5, a[i]);	
		}
	}


	public static void main(String[] args) throws InterruptedException {

		String[] input = StdIn.readAllStrings();
		int N = Integer.parseInt(input[0]);

		Integer[] d = new Integer[N];
		for (int i = 0; i < N; i++) {
			d[i] = StdRandom.uniform(1, 25);
		}
		show(d);
		
	}

}