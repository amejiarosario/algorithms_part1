import java.util.*;

/**
 * Brute force. Write a program Brute.java that examines 4 points at a time
 * and checks whether they all lie on the same line segment, printing out any
 * such line segments to standard output and drawing them using standard
 * drawing. To check whether the 4 points p, q, r, and s are collinear, check
 * whether the slopes between p and q, between p and r, and between p and s
 * are all equal.
 * 
 * The order of growth of the running time of your program should be N4 in the
 * worst case and it should use space proportional to N.
 */

/**
 * @author adrian
 * 
 */
public class Brute {
  
  public ArrayList<ArrayList<Point>> collinear(Point[] points){
    int l = points.length;
    
    if(l<4)
      return null;
    
    ArrayList<ArrayList<Point>> res = new ArrayList<ArrayList<Point>>();
    
    Arrays.sort(points);
    
    for(int a=0; a<l; a++)
      for(int b=a+1; b<l; b++)
        for(int c=b+1; c<l; c++)
          for(int d=c+1; d<l; d++){
            double ab = points[a].slopeTo(points[b]);
            double ac = points[a].slopeTo(points[c]);
            double ad = points[a].slopeTo(points[d]);
            if(ab == ac && ac == ad){
              ArrayList<Point> p = new ArrayList<Point>();
              p.add(points[a]);
              p.add(points[b]);
              p.add(points[c]);
              p.add(points[d]);
              res.add(p);
            }
          }
    return res;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

  }

}
