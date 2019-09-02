package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class ACircleOfStudents {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int q = in.nextInt();
        for (int z = 0; z < q; z++) {
            int n = in.nextInt();
            if (n == 1) {
                out.println("YES");
                continue;
            }
            int[] v = new int[n];
            int indexBegin = 0;
            int indexEnd = 0;
            for (int i = 0; i < n; i++) {
                v[i] = in.nextInt();
                if (v[i] == 1) {
                    indexBegin = i;
                }
                if (v[i] == n) {
                    indexEnd = i;
                }
            }
            boolean check = tryClockWise(v, indexBegin);
//            System.out.println(check);
            boolean checkCounter = tryCounterClockWise(v, indexBegin);
//            System.out.println(checkCounter);
            out.println((check || checkCounter) ? "YES" : "NO");
        }

    }

    private boolean tryCounterClockWise(int[] v, int indexEnd) {
        for (int c = 1; c < v.length; c++) {
            int next = (indexEnd - 1);
            if (next < 0) {
                next = v.length - 1;
            }
//            System.out.println("begin" + v[indexEnd] + " next "+ v[next]);
            if ((v[indexEnd] + 1) != (v[next])) {
                return false;
            }
            indexEnd = next;
        }
        return true;
    }

    private boolean tryClockWise(int[] v, int indexBegin) {
//            System.out.println("here");
        for (int c = 1; c < v.length; c++) {
//                System.out.println(v[indexBegin]);
            int next = (indexBegin + 1);
            if (next == v.length) {
                next = 0;
            }
//                System.out.println(v[next]);
            if ((v[indexBegin] + 1) != (v[next])) {
                return false;
            }
            indexBegin = next;
        }
        return true;
    }
}
