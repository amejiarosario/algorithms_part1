import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
  public void testSizeAndEmptyWithAddFirst() {
    strDeque.addFirst("A");
    strDeque.addFirst("B");
    strDeque.addFirst("C");    
    assertEquals(strDeque.size(), 3);
    assertEquals(strDeque.isEmpty(), false);
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
   * Test method for {@link Deque#size()}.
   */
  @Test
  public void testSizeAddLast() {
    strDeque.addLast("A");
    assertTrue(strDeque.size() == 1);
    strDeque.addLast("B");
    assertTrue(strDeque.size() == 2);
    strDeque.addLast("C");
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
  @Test(expected=NoSuchElementException.class)
  public void testRemoveFirst() {
    strDeque.removeFirst();
  }

  /**
   * Test method for {@link Deque#removeLast()}.
   */
  @Test(expected=NoSuchElementException.class)
  public void testRemoveLast() {
    strDeque.removeLast();
  }

  /**
   * Test method for {@link Deque#iterator()}.
   */
  @Test(expected=UnsupportedOperationException.class)
  public void testRemoveIterator() {
    Iterator<String> it = strDeque.iterator();
    it.remove();
  }

  /**
   * Test method for {@link Deque#iterator()}.
   */
  @Test(expected=NoSuchElementException.class)
  public void testIteratorNext() {
    Iterator<String> it = strDeque.iterator();
    it.next();
  }
  
  /**
   * Test method for {@link Deque#addFirst()}.
   */
  @Test
  public void testAddFirstWithIterator() {
    strDeque.addFirst("A");
    strDeque.addFirst("B");
    strDeque.addFirst("C");
    Iterator<String> it = strDeque.iterator();
//    assertEquals(strDeque.toString(), "C B A ");
    assertTrue(it.hasNext());
    assertTrue(it.next() == "C");
    assertTrue(it.hasNext());
    assertTrue(it.next() == "B");
    assertTrue(it.hasNext());
    assertTrue(it.next() == "A");
    assertEquals(it.hasNext(), false);
  }

  
  @Test(expected=UnsupportedOperationException.class)
  public void testIteratorRemoveException() {
    strDeque.addFirst("A");
    Iterator<String> it = strDeque.iterator();
    it.remove();   
  }  
  
  /**
   * Test method for {@link Deque#addLast(java.lang.Object)}.
   */
  @Test
  public void testAddLastWithIterator() {
    strDeque.addLast("A");
    strDeque.addLast("B");
    strDeque.addLast("C");
    Iterator<String> it = strDeque.iterator();
    assertTrue(it.hasNext());
    assertEquals(it.next(), "A");
    assertEquals(it.hasNext(), true);
    assertEquals(it.next(), "B");
    assertEquals(it.hasNext(), true);
    assertEquals(it.next(), "C");
    assertEquals(it.hasNext(), false);
  }
  
  @Test
  public void testRemoveFirstSizeAndEmpty() {
    strDeque.addFirst("A");
    strDeque.removeFirst();
    assertEquals(0,strDeque.size());
    assertEquals(true,strDeque.isEmpty());
  } 
  
  @Test
  public void testRemoveLastSizeAndEmpty() {
    strDeque.addFirst("A");
    strDeque.removeLast();
    assertEquals(0,strDeque.size());
    assertEquals(true,strDeque.isEmpty());
  }   
  
  @Test
  public void testRemoveFirstWithAddFirst() {
    strDeque.addFirst("A");
    strDeque.addFirst("B");
    strDeque.addFirst("C");
    assertEquals("C",strDeque.removeFirst());
    assertEquals("B",strDeque.removeFirst());
    assertEquals("A",strDeque.removeFirst());
  }
  
  @Test
  public void testRemoveLastWithAddFirst() {
    strDeque.addFirst("A");
    strDeque.addFirst("B");
    strDeque.addFirst("C");
    assertEquals("A",strDeque.removeLast());
    assertEquals("B",strDeque.removeLast());
    assertEquals("C",strDeque.removeLast());
  }
  
  @Test
  public void testRemoveLastWithAddLast() {
    strDeque.addLast("A");
    strDeque.addLast("B");
    strDeque.addLast("C");
    assertEquals("C",strDeque.removeLast());
    assertEquals("B",strDeque.removeLast());
    assertEquals("A",strDeque.removeLast());
  }
  
}
