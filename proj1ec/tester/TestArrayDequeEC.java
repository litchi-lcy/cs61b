package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;


public class TestArrayDequeEC {


    @Test
    public void test2() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        String message = "";
        for (int i = 0; i < 100; i++) {
            sad1.addLast(i);
            sad2.addLast(i);
            Integer sad11 = sad1.get(i);
            Integer sad211 = sad2.get(i);
            if (sad11 == sad211) {
                message += "addLast(" + i + ")\n";
            } else {
                message += "addFirst(" + i + ")\n";
            }
            assertEquals(message,sad1.get(i), sad2.get(i));
        }

        for (int i = 0; i < 100; i++) {
            Integer sad11 = sad1.removeFirst();
            Integer sad22 = sad2.removeFirst();
            if (sad11 == sad22) {
                message += "removeFirst()\n";
            } else {
                message += "removeFirst()\n";
            }
            assertEquals(message,sad11,sad22);
        }
        for (int i = 0; i <100; i++) {
            Integer sad11 = sad1.removeLast();
            Integer sad22 = sad2.removeLast();
            if (sad11 == sad22) {
                message += "removeLast()\n";
            } else {
                message += "removeLast()\n";
            }
            assertEquals(message,sad11,sad22);
        }

    }
}