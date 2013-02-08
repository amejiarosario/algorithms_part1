/**
 * Program to estimate the value of the percolation threshold via Monte Carlo simulation
 */

/**
 * @author adrian
 * 
 */
public class Percolation {
	private int n;
	private int[][] open;
	private WeightedQuickUnionUF uf;

	/**
	 * Create N-by-N grid, with all sites blocked
	 * 
	 * @param N
	 */
	public Percolation(int N) {
		n = N;
		open = new int[N][N];
		uf = new WeightedQuickUnionUF(N * N + 2);
	}

	/**
	 * open site (row i, column j) if it is not already
	 * 
	 * @param i
	 *            row from 1 to N
	 * @param j
	 *            column from 1 to N
	 * @exception java.lang.IndexOutOfBoundsException
	 *                if either i or j is outside this range
	 */
	public void open(int i, int j) {
		openSite(i, j);
		System.out.printf("open(%d,%d)\n", i, j);
		int d = xyTo1D(i, j);
		checkAndOpen(i - 1, j, d);
		checkAndOpen(i + 1, j, d);
		checkAndOpen(i, j - 1, d);
		checkAndOpen(i, j + 1, d);
	}

	private void checkAndOpen(int i, int j, int d) {
		if (isOpen(i, j)) {
			uf.union(d, xyTo1D(i, j));
			System.out.printf("\tunion(%d,%d)\n", d, xyTo1D(i, j));
		}
	}

	/**
	 * is site (row i, column j) open?
	 * 
	 * @param i
	 *            row from 1 to N
	 * @param j
	 *            column from 1 to N
	 * @exception java.lang.IndexOutOfBoundsException
	 *                if either i or j is outside this range
	 * @return
	 */
	public boolean isOpen(int i, int j) {
		i--;
		j--; // zero-indexed array conversion
		try {
			checkBoundaries(i, j);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return open[i][j] == 1;
	}

	/**
	 * Translates from grid(x,y) to 1D array
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private int xyTo1D(int i, int j) {
		return n * (i - 1) + j;
	}

	/**
	 * Mark the site as open
	 * 
	 * @param i
	 *            row from 1 to N
	 * @param j
	 *            column from 1 to N
	 */
	private void openSite(int i, int j) {
		i--;
		j--;
		checkBoundaries(i, j);
		open[i][j] = 1;
	}

	/**
	 * is site (row i, column j) full?
	 * 
	 * @param i
	 * @param j
	 * @exception java.lang.IndexOutOfBoundsException
	 *                if either i or j is outside this range
	 * @return
	 */
	public boolean isFull(int i, int j) {
		checkBoundaries(i, j);
		return false;
	}

	/**
	 * does the system percolate?
	 * 
	 * @return
	 */
	public boolean percolates() {
		if (n == 1) {
			if (open[0][0] == 1)
				return true;
			else
				return false;
		}

		// virtual top site
		for (int i = 1; i <= n; i++)
			checkAndOpen(1, i, 0);

		// virtual bottom site
		for (int i = 1; i <= n; i++)
			checkAndOpen(n, i, n * n + 1);

		return uf.connected(0, n * n + 1);
	}

	private void checkBoundaries(int i, int j) {
		if (i >= n || j >= n || i < 0 || j < 0)
			throw new java.lang.IndexOutOfBoundsException(
					"Either i or j is outside range N");
	}
}
