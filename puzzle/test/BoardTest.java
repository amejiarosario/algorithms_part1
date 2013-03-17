import static org.junit.Assert.*;

import java.util.Iterator;

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
  private final int[][] a2 = {
      {1,0},
      {3,2}
  };
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
  public void testNeighbors3() {
    boolean[] bool = new boolean[4];
    
    Board n1 = new Board(new int[][]{
        {8,0,3},
        {4,1,2},
        {7,6,5}
    });
    Board n2 = new Board(new int[][]{
        {8,1,3},
        {4,2,0},
        {7,6,5}
    });
    Board n3 = new Board(new int[][]{
        {8,1,3},
        {4,6,2},
        {7,0,5}
    });
    Board n4 = new Board(new int[][]{
        {8,1,3},
        {0,4,2},
        {7,6,5}
    });
//    Iterator<Board> it = b3.neighbors().iterator();
    for(Board b: b3.neighbors()){
      if(b.toString().equals(n1.toString())){
        bool[0] = true;
      } else if (b.toString().equals(n2.toString())){
        bool[1] = true;
      } else if (b.toString().equals(n3.toString())){
        bool[2] = true;
      } else if (b.toString().equals(n4.toString())){
        bool[3] = true;        
      }
//      System.out.println(b);
    }
    for(boolean u: bool)
    {
      assertTrue(u);
    }
  }
  
  /**
   * Test method for {@link Board#neighbors()}.
   */
  @Test
  public void testNeighbors2() {
    boolean[] bool = new boolean[2];
    
    Board n1 = new Board(new int[][]{
        {0,1},
        {3,2}
    });
    Board n2 = new Board(new int[][]{
        {1,2},
        {3,0}
    });
    for(Board b: b2.neighbors()){
      if(b.toString().equals(n1.toString())){
        bool[0] = true;
      } else if (b.toString().equals(n2.toString())){
        bool[1] = true;
      }
//      System.out.println(b);
    }
    for(boolean u: bool)
    {
      assertTrue(u);
    }
  }
  
  @Test(timeout=50)
  public void testSolver() {
    int[][] a = new int[][]{
        {0,1,3},
        {4,2,5},
        {7,8,6},
    };
    Solver sol = new Solver(new Board(a));
    assertEquals(4,sol.moves());
//    for(Board b: sol.solution()){
//      System.out.println(b);
//    }
//    System.out.println();
  }
}
