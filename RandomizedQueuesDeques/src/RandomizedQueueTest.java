import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
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
public class RandomizedQueueTest {

  private RandomizedQueue<String> strDeque;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    strDeque = new RandomizedQueue<String>();
  }

  @Test
  public void testIsEmpty() {
    assertTrue(strDeque.isEmpty());
  }
  
  @Test
  public void testSize() {
    assertTrue(strDeque.size() == 0);
  }
  
  @Test
  public void testIsNotEmpty() {
    strDeque.enqueue("A");
    assertFalse(strDeque.isEmpty());
  }  

  @Test
  public void testSizeAndEmptyWithEnqueue() {
    strDeque.enqueue("A");
    strDeque.enqueue("B");
    strDeque.enqueue("C");    
    assertEquals(strDeque.size(), 3);
    assertEquals(strDeque.isEmpty(), false);
  }
  
  @Test
  public void testSizeAndEmptyWithDequeue() {
    strDeque.enqueue("A");
    strDeque.enqueue("B");
    strDeque.enqueue("C");
    strDeque.dequeue();
    strDeque.dequeue();
    strDeque.dequeue();      
    assertEquals(strDeque.size(), 0);
    assertEquals(strDeque.isEmpty(), true);
  }
  
  @Test
  public void testEnqueueAndDequeue() {
    strDeque.enqueue("A");
    assertEquals("A",strDeque.dequeue());
  }
  
  @Test
  public void testEnqueueAndDequeueWithNItems() {
    String ele[] = new String[]{"A","B","C","D", "E"};
    for(String e: ele)
      strDeque.enqueue(e);
    
    ArrayList<String> arr = new ArrayList<String>();
    for(String e: ele)
      arr.add(e);

    for(String e : ele){
      assertThat(arr, hasItem(strDeque.dequeue()));
      arr.remove(e);
    }
  }  
  
  @Test(expected=NoSuchElementException.class)
  public void testEnqueueAndDequeueUnderflow() {
    strDeque.dequeue();
  }
}
