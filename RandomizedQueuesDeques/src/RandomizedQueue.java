import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 */

/**
 * @author adrian
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
  private Item[] a;
  private int N;
  private int head;
  private int tail;
  
  @SuppressWarnings("unchecked")
  public RandomizedQueue()           // construct an empty randomized queue
  {
    a = (Item[]) new Object[2];
    N = head = tail = 0;
  }
  public boolean isEmpty()           // is the queue empty?
  {
    return size() == 0;
  }
  
  public int size()                  // return the number of items on the queue
  {
    return N;
  }
  
  private void resize(int capacity) {
    if(capacity < N || capacity < 1)
      return;
    @SuppressWarnings("unchecked")
    Item[] tmp = (Item[]) new Object[capacity];
    for(int i=0; i<N; i++)
      tmp[i] = a[i];
    a = tmp;
    System.out.println("resize="+a.length);
  }
  
  public void enqueue(Item item)     // add the item
  {
    if(N >= a.length)
      resize(2*a.length);
    a[tail++] = item;
    N++;
  }

  public Item dequeue()              // delete and return a random item
  {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    N--;
    return a[head++];
  }
  public Item sample()               // return (but do not delete) a random item
  {
    return null;
    
  }
  public Iterator<Item> iterator()   // return an independent iterator over items in random order
  {
    return null;
  }
}
