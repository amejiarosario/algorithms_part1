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
public class BoardTest {
  private Board b2, b3;
  private final int[][] a2 = {{1,0},{3,2}};
  private final int[][] a3 = {
      {8,1,3},
      {4,0,2},
      {7,6,5}
  };

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    b3 = new Board(a3);
    b2 = new Board(a2);
  }
  
  /**
   * Test method for {@link Board#dimension()}.
   */
  @Test
  public void testDimension2() {
    b2 = new Board(a2);
    assertEquals(2,b2.dimension());
  }

  /**
   * Test method for {@link Board#dimension()}.
   */
  @Test
  public void testDimension3() {
    assertEquals(3,b3.dimension());
  }
  
//  /**
//   * Test method for {@link Board#hamming()}.
//   */
//  @Test
//  public void testHamming() {
//    int[][] a = {{8,1,3},{4,0,2},{7,6,5}};
//    Board b = new Board(a);
//    assertEquals(5, b.hamming());
//  }
  
  /**
   * Test method for {@link Board#hamming()}.
   */
  @Test
  public void testHamming3() {
    assertEquals(b3.hamming(),5);
  }
  
  /**
   * Test method for {@link Board#hamming()}.
   */
  @Test
  public void testHamming2() {
    assertEquals(1, b2.hamming());
  }

  /**
   * Test method for {@link Board#manhattan()}.
   */
  @Test
  public void testManhattan() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link Board#isGoal()}.
   */
  @Test
  public void testIsGoal() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link Board#twin()}.
   */
  @Test
  public void testTwin() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link Board#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObject() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link Board#neighbors()}.
   */
  @Test
  public void testNeighbors() {
    fail("Not yet implemented");
  }

  /**
   * Test method for {@link Board#toString()}.
   */
  @Test
  public void testToString() {
    fail("Not yet implemented");
  }

}
