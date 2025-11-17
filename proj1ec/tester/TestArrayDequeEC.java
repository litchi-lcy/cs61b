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
        int N = 500000;
        for (int j = 0; j < N; j++) {
            sad1.addFirst(j);
            sad2.addFirst(j);
        }
        for (int i = 0; i < N; i += 1) {
            int randc = StdRandom.uniform(0,4);
            int rand = StdRandom.uniform(0,100000);
            Integer studentResult = null;
            Integer correvtResult = null;
            String message = "";

            if (randc == 0) {
                sad1.addFirst(rand);
                sad2.addFirst(rand);
                message += "add First(" + rand + ")\n";
            } else if (randc == 1) {
                sad1.addLast(rand);
                sad2.addLast(rand);
                message += "add Last(" + rand + ")\n";
            } else if (randc == 2) {
                studentResult = sad1.removeFirst();
                correvtResult = sad2.removeFirst();
                message += "remove First():"+correvtResult+"\n";
            }  else if (randc == 3) {
                studentResult = sad1.removeLast();
                correvtResult = sad2.removeLast();
                message += "remove Last():"+correvtResult+"\n";
            }
            if (studentResult != null) {
                assertEquals(message,studentResult,correvtResult);
            }

        }



    }
}