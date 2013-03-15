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
  private Board b2, b3, b4;
  private final int[][] a2 = {{1,0},{3,2}};
  private final int[][] a3 = {
      {8,1,3},
      {4,0,2},
      {7,6,5}
  };
  private final int[][] a4 = {
      {1,2,3,4},
      {5,6,7,8},
      {9,10,11,12},
      {13,14,15,0}
 };

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    b3 = new Board(a3);
    b2 = new Board(a2);
    b4 = new Board(a4);
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
  
  /**
   * Test method for {@link Board#dimension()}.
   */
  @Test
  public void testDimension4() {
    assertEquals(4,b4.dimension());
  }
  
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
   * Test method for {@link Board#hamming()}.
   */
  @Test
  public void testHamming4() {
    assertEquals(0, b4.hamming());
  }

  /**
   * Test method for {@link Board#manhattan()}.
   */
  @Test
  public void testManhattan3() {
    assertEquals(10,b3.manhattan());
  }
  
  /**
   * Test method for {@link Board#manhattan()}.
   */
  @Test
  public void testManhattan2() {
    assertEquals(1,b2.manhattan());
  }
  
  /**
   * Test method for {@link Board#manhattan()}.
   */
  @Test
  public void testManhattan4() {
    assertEquals(0,b4.manhattan());
  }

  /**
   * Test method for {@link Board#isGoal()}.
   */
  @Test
  public void testIsGoal2() {
    assertEquals(false,b2.isGoal());
  }
  
  /**
   * Test method for {@link Board#isGoal()}.
   */
  @Test
  public void testIsGoal3() {
    assertEquals(false,b3.isGoal());
  }
  
  /**
   * Test method for {@link Board#isGoal()}.
   */
  @Test
  public void testIsGoal4() {
    assertEquals(true,b4.isGoal());
  }

  /**
   * Test method for {@link Board#twin()}.
   */
//  @Test
//  public void testTwin() {
//    System.out.println(b3.toString());
//    System.out.println(b3.twin().toString());
//  }

  /**
   * Test method for {@link Board#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObjectSame() {
    assertEquals(true, b3.equals(b3));
  }
  
  /**
   * Test method for {@link Board#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObjectDifferent() {
    assertEquals(false, b3.equals(b3.twin()));
  }
  
  /**
   * Test method for {@link Board#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObjectDifferentLength() {
    assertEquals(false, b3.equals(b2));
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
