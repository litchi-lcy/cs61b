package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;


public class TestArrayDequeEC {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        int N = 10;
        for (int j = 0; j < N; j++) {
            sad1.addFirst(j);
            sad2.addFirst(j);
        }
        for (int i = 0; i < N; i += 1) {
            int randc = StdRandom.uniform(0,4);
            int rand = StdRandom.uniform(0,1000);
            if (randc == 0) {
                sad1.addFirst(rand);
                sad2.addFirst(rand);
                assertEquals(sad1.get(0), sad2.get(0));
                assertEquals(sad1.get(1), sad2.get(1));
            } else if (randc == 1) {
                sad1.addLast(rand);
                sad2.addLast(rand);
                assertEquals(sad1.get(sad1.size()-1), sad2.get(sad2.size()-1));
                assertEquals(sad1.size(), sad2.size());
            } else if (randc == 2) {
                assertEquals(sad1.removeFirst(), sad2.removeFirst());
            } else if (randc == 3) {
                assertEquals(sad1.removeLast(), sad2.removeLast());
            }

        }


    }

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
                message += "addFirst(" + i + "), " + "student was " + sad11 + ", " + "correct was " + sad211;
            }
            assertEquals(sad1.get(i), sad2.get(i));
        }

        for (int i = 0; i < 100; i++) {
            Integer sad11 = sad1.removeFirst();
            Integer sad22 = sad2.removeFirst();
            if (sad11 == sad22) {
                message += "removeFirst(): " + sad11 + "\n";
            } else {
                message += "removeFirst(), " + "student was "+sad11 + ", correct was "+sad22 +"\n";
            }
            assertEquals(message,sad11,sad22);
        }
        for (int i = 0; i <100; i++) {
            Integer sad11 = sad1.removeLast();
            Integer sad22 = sad2.removeLast();
            if (sad11 == sad22) {
                message += "removeLast(): " + sad11 + "\n";
            } else {
                message += "removeLast(), " + "student was "+sad11 + ", correct was "+sad22 +"\n";
            }
            assertEquals(message,sad11,sad22);
        }

    }
}