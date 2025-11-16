package deque;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test

    public void testAdd() {
        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertFalse("lld1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();

    }


    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  lld1 = new ArrayDeque<>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 99999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }


    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        LinkedListDeque<Integer> b = new LinkedListDeque<>();
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

        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> e_L = new LinkedListDeque<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 1000);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 10000);
                L.addLast(randVal);
                e_L.addLast(randVal);

            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int e_size = e_L.size();

                assertEquals(size, e_size);
            } else if (operationNumber == 2&&L.size()>0) {
                int randVal = StdRandom.uniform(0, 10000);
                assertEquals(L.removeFirst(),e_L.removeFirst());

            } else if (operationNumber == 3&&L.size()>0) {
                int randVal = StdRandom.uniform(0, 10000);
                assertEquals(L.removeLast(),e_L.removeLast());

            }

        }
    }

    @Test
    public void testprint() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> e_L = new LinkedListDeque<>();
        int N = 5;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 10000);
                L.addLast(randVal);
                e_L.addLast(randVal);
            }
            else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 10000);
                L.addFirst(randVal);
                e_L.addFirst(randVal);
            }
            L.printDeque();
            System.out.println();
            e_L.printDeque();
            System.out.println();
        }
    }


    @Test
    public void IteratorTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> e_L = new LinkedListDeque<>();
        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 10000);
                L.addLast(randVal);
                e_L.addLast(randVal);
            }
            else if (operationNumber == 1) {
                L.addFirst(operationNumber);
                e_L.addFirst(operationNumber);
            }
        }
        Iterator it = L.iterator();
        Iterator lit = e_L.iterator();
        while (it.hasNext()) {
            assertEquals(it.next(),lit.next());
        }
    }

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        LinkedListDeque<Integer> e_L = new LinkedListDeque<>();
        int N = 5;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 10000);
                L.addLast(randVal);
                e_L.addLast(randVal);
            }
            else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 10000);
                L.addFirst(randVal);
                e_L.addFirst(randVal);
            }
        }
        assertEquals(true, L.equals(e_L));

    }
}





