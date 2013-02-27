import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author adrian
 * 
 */
public class PointTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  // Slope. To begin, implement the slopeTo() method. Be sure to consider a
  // variety of corner cases, including horizontal, vertical, and degenerate
  // line segments.

  // same point appear, for the slopeTo()

  // do not print permutations of points on a line segment (e.g., if you output
  // p→q→r→s, do not also output either s→r→q→p or p→r→q→s)

  // for full credit in Fast.java, do not print or plot subsegments of a line
  // segment containing 5 or more points (e.g., if you output p→q→r→s→t, do not
  // also output either p→q→s→t or q→r→s→t); you may print out such subsegments
  // in Brute.java.

  // My program fails only on (some) vertical line segments. What could be going
  // wrong? Are you dividing by zero? With integers, this produces a runtime
  // exception. With floating-point numbers, 1.0/0.0 is positive infinity and
  // -1.0/0.0 is negative infinity. You may also use the constants
  // Double.POSITIVE_INFINITY and Double.NEGATIVE_INFINITY.

  // Note that while (x == y) is guaranteed to be true, Arrays.sort() treats
  // negative zero as strictly less than positive zero. Thus, to make the
  // specification precise, we require you to return positive zero for
  // horizontal line segments.

}
