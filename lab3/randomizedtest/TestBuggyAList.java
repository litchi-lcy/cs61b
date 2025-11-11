package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.om.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<Integer>();
        BuggyAList<Integer> b = new BuggyAList<Integer>();
        a.addLast(4);
        b.addLast(4);
        a.addLast(5);
        b.addLast(5);
        a.addLast(6);
        b.addLast(6);
        assertEquals(a.removeLast(),b.removeLast());
        assertEquals(a.removeLast(),b.removeLast());
        assertEquals(a.removeLast(),b.removeLast());
  }

  @Test
    public void testThreeAddThreeRemove2() {

      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> e_L = new BuggyAList<>();
      int N = 500;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              e_L.addLast(randVal);
             
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int e_size = e_L.size();

              assertEquals(size, e_size);
          } else if (operationNumber == 2&&L.size()>0) {
              int randVal = StdRandom.uniform(0, 100);
              assertEquals(L.getLast(),e_L.getLast());

          } else if (operationNumber == 3&&L.size()>0) {
              int randVal = StdRandom.uniform(0, 100);
              assertEquals(L.removeLast(),e_L.removeLast());

          }

      }
  }
}

