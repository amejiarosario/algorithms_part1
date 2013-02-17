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
public class DequeTest {
  
  private Deque<String> strDeque;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    strDeque = new Deque<String>();
  }

  /**
   * Test method for {@link Deque#isEmpty()}.
   */
  @Test
  public void testIsEmpty() {
    assertTrue(strDeque.isEmpty());
  }

  /**
   * Test method for {@link Deque#isEmpty()}.
   */
  @Test
  public void testIsNotEmpty() {
    strDeque.addFirst("A");
    assertFalse(strDeque.isEmpty());
  }  

  /**
   * Test method for {@link Deque#size()}.
   */
  @Test
  public void testSize() {
    assertTrue(strDeque.size() == 0);
  }
  
  /**
   * Test method for {@link Deque#size()}.
   */
  @Test
  public void testSizeAddFirst() {
    strDeque.addFirst("A");
    assertTrue(strDeque.size() == 1);
    strDeque.addFirst("B");
    assertTrue(strDeque.size() == 2);
    strDeque.addFirst("C");
    assertTrue(strDeque.size() == 3);    
  }

  /**
   * Test method for {@link Deque#addFirst(java.lang.Object)}.
   */
  @Test(expected=NullPointerException.class)
  public void testAddFirst() {
    strDeque.addFirst(null);
  }

  /**
   * Test method for {@link Deque#addLast(java.lang.Object)}.
   */
  @Test(expected=NullPointerException.class)
  public void testAddLast() {
    strDeque.addLast(null);
  }

  /**
   * Test method for {@link Deque#removeFirst()}.
   */
  @Test(expected=UnsupportedOperationException.class)
  public void testRemoveFirst() {
    strDeque.removeFirst();
  }

  /**
   * Test method for {@link Deque#removeLast()}.
   */
  @Test(expected=UnsupportedOperationException.class)
  public void testRemoveLast() {
    strDeque.removeLast();
  }

  /**
   * Test method for {@link Deque#iterator()}.
   */
  @Test
  public void testIterator() {
    Iterator<String> it = strDeque.iterator();
    strDeque.addFirst("A");
    strDeque.addFirst("B");
    strDeque.addFirst("C");
    assertEquals(strDeque.toString(), "C B A ");
    assertTrue(it.hasNext());
    assertTrue(it.next() == "A");
    assertTrue(it.hasNext());
    assertTrue(it.next() == "B");
    assertTrue(it.hasNext());
    assertTrue(it.next() == "C");    
  }

}
