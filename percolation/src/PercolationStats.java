/**
 * Program to estimate the value of the percolation 
 * threshold via Monte Carlo simulation
 */

/**
 * @author adrian
 * 
 */
public class PercolationStats {
	private int n, t;
	private int results[];
	/**
	 * perform T independent computational experiments on an N-by-N grid
	 * 
	 * @param N
	 * @param T
	 * @exception java.lang.IllegalArgumentException
	 *                if either N ² 0 or T ² 0
	 */
	public PercolationStats(int N, int T) {
		n = N;
		t = T;
		results = new int[T];
		Percolation per;
		for (int t = 0; t < T; t++) {
			per = new Percolation(N);

		}

	}

	/**
	 * sample mean of percolation threshold
	 * 
	 * @return
	 */
	public double mean() {
		return 0.0;
	}

	/**
	 * sample standard deviation of percolation threshold
	 * 
	 * @return
	 */
	public double stddev() {
		if(t==1) return Double.NaN;
		return 0.0;
	}

	/**
	 * returns lower bound of the 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceLo() {
		return 0.0;
	}

	//
	/**
	 * returns upper bound of the 95% confidence interval
	 * 
	 * @return
	 */
	public double confidenceHi() {
		return 0.0;
	}

	/**
	 * Method that takes two command-line arguments N and T, performs T
	 * independent computational experiments (discussed above) on an N-by-N
	 * grid, and prints out the mean, standard deviation, and the 95% confidence
	 * interval for the percolation threshold.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);

		PercolationStats perStat = new PercolationStats(N, T);

		System.out.printf("mean                    = %f\n", perStat.mean());
		System.out.printf("stddev                  = %f\n", perStat.stddev());
		System.out.printf("95%% confidence interval = %f, %f\n",
				perStat.confidenceLo(), perStat.confidenceHi());

	}
}
