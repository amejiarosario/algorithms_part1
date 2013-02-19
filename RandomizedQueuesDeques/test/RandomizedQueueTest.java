import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
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
public class RandomizedQueueTest {

  private RandomizedQueue<String> strQueue;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    strQueue = new RandomizedQueue<String>();
  }

  @Test
  public void testIsEmpty() {
    assertTrue(strQueue.isEmpty());
  }
  
  @Test
  public void testSize() {
    assertTrue(strQueue.size() == 0);
  }
  
  @Test
  public void testIsNotEmpty() {
    strQueue.enqueue("A");
    assertFalse(strQueue.isEmpty());
  }  

  @Test
  public void testSizeAndEmptyWithEnqueue() {
    strQueue.enqueue("A");
    strQueue.enqueue("B");
    strQueue.enqueue("C");    
    assertEquals(strQueue.size(), 3);
    assertEquals(strQueue.isEmpty(), false);
  }
  
  @Test(timeout=50)
  public void testSizeAndEmptyWithQueueue() {
    strQueue.enqueue("A");
    strQueue.enqueue("B");
    strQueue.enqueue("C");
    strQueue.dequeue();
    strQueue.dequeue();
    strQueue.dequeue();      
    assertEquals(strQueue.size(), 0);
    assertEquals(strQueue.isEmpty(), true);
  }
  
  @Test(timeout=50)
  public void testEnqueueAndQueueue() {
    strQueue.enqueue("A");
    assertEquals("A",strQueue.dequeue());
  }
  
  @Test(timeout=50)
  public void testEnqueueSize() {
    String ele[] = new String[]{"A","B","C","D", "E"};
    
    for(String e: ele)
      strQueue.enqueue(e);
    
    int count=-1;
    Iterator<String> it = strQueue.iterator();
    while(it.hasNext()){
      it.next();
      count++;
    }
    
//    System.out.println(strQueue.toStr());
    assertEquals(ele.length,count);
  }
  
  // FIXME make it random ready
  @Test(timeout=50)
  public void testEnqueueAndQueueueWithNItems() {
    String ele[] = new String[]{"A","B","C","D", "E"};
    for(String e: ele)
      strQueue.enqueue(e);
    
    ArrayList<String> arr = new ArrayList<String>();
    for(String e: ele)
      arr.add(e);

    for(String e : ele){
      assertThat(arr, hasItem(strQueue.dequeue()));
      arr.remove(e);
    }
  }
  
  @Test(expected=NoSuchElementException.class)
  public void testEnqueueAndQueueueUnderflow() {
    strQueue.dequeue();
  }
 
  @Test(expected=UnsupportedOperationException.class)
  public void testRemoveIterator() {
    Iterator<String> it = strQueue.iterator();
    it.remove();
  }
  
  @Test(expected=NoSuchElementException.class)
  public void testIteratorNext() {
    Iterator<String> it = strQueue.iterator();
    it.next();
  }
  
  // FIXME make it random ready
  @Test(timeout=150)
  public void testIterator() {
    String ele[] = new String[]{"A","B","C","D", "E"};
    ArrayList<String> arr = new ArrayList<String>();
    for(String e: ele)
      arr.add(e);
    
    for(String e: ele)
      strQueue.enqueue(e);
    
    Iterator<String> it = strQueue.iterator();
    for(String e: ele){
      assertEquals(it.hasNext(), true);
      assertThat(arr, hasItem(it.next()));
    }
  }
  
  // FIXME make it random ready
  @Test(timeout=50)
  public void testIteratorToString() {
    String ele[] = new String[]{"A","B","C","D", "E"};
    StringBuilder sb = new StringBuilder();
    for(String e: ele){
      sb.append(e+" ");
      strQueue.enqueue(e);
    }
    assertEquals(sb.toString(), strQueue.toStr());
  }
  
  @Test(timeout=150)
  public void testCapacityIncreaseDoubling() {
    RandomizedQueue<Integer> intQueue = new RandomizedQueue<Integer>();
    for(int i=0; i<100; i++){
      intQueue.enqueue(i);
      if(i<2) assertEquals(intQueue.capacity(), 2);
      else{
        int nextLg = (int) Math.pow(2,Math.ceil(Math.log(i+1)/Math.log(2)));
//        System.out.println(String.format("i=%d; capacity=%d; nextLog=%d",i,intQueue.capacity(), nextLg));
        assertEquals(intQueue.capacity(), nextLg);
      }
    }
  }

  @Test(timeout=150)
  public void testCapacityDecreaseHalving() {
    RandomizedQueue<Integer> intQueue = new RandomizedQueue<Integer>();
    
    for(int i=0; i<100; i++)
      intQueue.enqueue(i);
    
    int capacity = 128;
    
    for(int i=99; i>=0; i--){
      intQueue.dequeue();
      if(capacity/4 > intQueue.size())
        capacity /= 2;
      //System.out.println(String.format("i=%d; N=%d a_capacity=%d; e_capacity=%d",i,intQueue.size(), intQueue.capacity(), capacity));
      assertEquals(intQueue.capacity(), capacity);
    }
  }
  
  @Test(timeout=150)
  public void testSimultaneousIterator() {
    String ele[] = new String[]{"A","B","C","D", "E"};
    
    for(String e: ele)
      strQueue.enqueue(e);
    
    Iterator<String> it = strQueue.iterator();
    Iterator<String> it2 = strQueue.iterator();
    
    for(int i=0; i< ele.length+1; i++){
      assertEquals(it.hasNext(), true);
      assertEquals(it2.hasNext(), true);
      it.next();
    }
    assertEquals(it.hasNext(), false);
    assertEquals(it2.hasNext(), true);
    
    for(int i=0; i< ele.length+1; i++){
      assertEquals(it2.hasNext(), true);
      it2.next();
    }
    assertEquals(it2.hasNext(), false);    
  }
  
  @Test(timeout=150)
  public void testRandomIncreasingAndDecreasing() {
    RandomizedQueue<Integer> intQueue = new RandomizedQueue<Integer>();
    
    for(int i=0; i<100; i++)
      intQueue.enqueue(i);
    
    for(int i=0; i<100; i++)
      assertNotSame(i, (int) intQueue.dequeue());
  }
  
  @Test(timeout=150)
  public void testSample(){
    RandomizedQueue<Integer> intQueue = new RandomizedQueue<Integer>();
    int N = 100;
    Boolean arr[] = new Boolean[N];
    
    for(int i=0; i<N; i++){
      intQueue.enqueue(i);
      arr[i] = false;
    }
    
    for(int i=0; i < N; i++){
      //System.out.println(i);
      int num = intQueue.sample();
      assertEquals(arr[num], false);
      arr[num] = true;
    }
  }
}
