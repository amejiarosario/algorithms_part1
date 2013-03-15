/**
 * 
 */

/**
 * @author adrian
 *
 */
public class Board {
    private int[][] b;
    
    public Board(int[][] blocks)           // construct a board from an N-by-N array of blocks
                                           // (where blocks[i][j] = block in row i, column j)
    {
      this.b = blocks;
    }
    
    public int dimension()                 // board dimension N
    {
      return b.length;
    }
    
    public int hamming()                   // number of blocks out of place
    {
      int h=0, c=1;
      for(int x=0; x<b.length; x++)
        for(int y=0; y<b.length; y++)
          if(c++ != b[x][y])
            h++;
      return h-1;
    }
    
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    {
      int h=0, c=1;
      for(int x=0; x<b.length; x++)
        for(int y=0; y<b.length; y++)
          if(c++ != b[x][y]){
            for(int p=0; p<b.length; p++)
              for(int r=0; r<b.length; r++)
                if((c-1) == b[p][r]){
                  h += Math.abs(x-p) + Math.abs(y-r);
                }
            if(c == b.length*b.length) break;
          }
      return h;
    }
    public boolean isGoal()                // is this board the goal board?
    {
      return this.hamming() == 0;
    }
    public Board twin()                    // a board obtained by exchanging two adjacent blocks in the same row
    {
      return null;
    }
    public boolean equals(Object y)        // does this board equal y?
    {
      return false;
    }
    public Iterable<Board> neighbors()     // all neighboring boards
    {
      return null;
    }
    public String toString()               // string representation of the board (in the output format specified below)
    {
      return null;
    }
    
    
}
