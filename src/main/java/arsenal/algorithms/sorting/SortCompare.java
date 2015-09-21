package arsenal.algorithms.sorting;

import utils.StdRandom;
import utils.Stopwatch;

/**
* an example run $java SortCompare <algorithm1> <algorithm2> <N> <T>
*	
*/

public class SortCompare {

	public static void main(String[] args) {
		String algo1 = args[0];
		String algo2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);

		System.out.println(algo1 + " : " + algo2 + " : " + N + " : " + T);
		double tAlgo1 = timeRandomInput(algo1, N, T);
		double tAlgo2 = timeRandomInput(algo2, N, T);
		
		System.out.println(algo1 + " : " + tAlgo1);
		System.out.println(algo2 + " : " + tAlgo2);
		System.out.printf("for %d random doubles \n     %s is ", N, algo1);
		System.out.printf("%.1f times faster than %s", tAlgo2/tAlgo1, algo2 );
	}

	public static double timeRandomInput(String algo, int N, int T ) {
		Double[] d = new Double[N];
		double time = 0.0;
		for (int t = 0; t < T ; t++) {
			for (int i = 0; i < N; i++) {
				d[i] = StdRandom.uniform(1.0, 10000.0);
			}
			time += time(algo, d);
		}
		return time;
	}

	public static double time(String algo, Double[] input) {
		Stopwatch watch = new Stopwatch();
		if("Insertion".equals(algo)) {
			Insertion.sort(input);
		} else if("Selection".equals(algo)) {
			Selection.sort(input);
		}
		return watch.elapsedTime();
	}

}