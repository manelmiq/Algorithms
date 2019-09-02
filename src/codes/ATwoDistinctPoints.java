package codes;

import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class ATwoDistinctPoints {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int l1, r1, l2, r2, a, b;
            l1 = in.nextInt();
            r1 = in.nextInt();
            l2 = in.nextInt();
            r2 = in.nextInt();
            a = Math.min(l1, l2);
            if (a == l1) {
                b = r2;
                out.println(a + " " + b);
            } else {
                b = r1;
                out.println(b + " " + a);
            }

        }
    }
}
