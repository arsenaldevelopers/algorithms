package arsenal.algorithms.sorting;


import utils.StdDraw;
import utils.StdRandom;

public class Histogram {
	public static void main(String[] args) {
		int N = 50;
		double[] a = new double[N];
		for (int i = 1; i < N; i++)
		   a[i] = StdRandom.uniform();
		for (int i = 0; i < N; i++) {
		   double x = 1.0*i/(2*N);
		   double y = a[i]/4.0;
		   double rw = 0.25/N;
		   double rh = a[i]/4.0;
		   StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
}