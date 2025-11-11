package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        SLList<Integer> s =new SLList<>();
        int N = 1000;
        int M = 10000;
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        for(int k = 1 ; k <= 8; k++) {

            for (int i = 1; i <= N; i++) {
                s.addLast(0);
            }
            Stopwatch sw = new Stopwatch();
            for(int j = 1; j <= M; j++) {
                s.getLast();
            }
            double timeInseconds = sw.elapsedTime();
            opCounts.addLast(M);
            times.addLast(timeInseconds);
            Ns.addLast(N);
            N = N * 2;
        }
        printTimingTable(Ns, times, opCounts);
    }

}
