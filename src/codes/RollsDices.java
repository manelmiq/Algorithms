package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class RollsDices {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int d = in.nextInt();
        int f = in.nextInt();
        int t = in.nextInt();
        out.println(numRollsToTarget(d, f, t));
    }

    public int numRollsToTarget(int d, int f, int target) {
        int dices[] = new int[d];
        for (int i = 0; i < d; i++) {
            dices[i] = 1;
        }

        return 0;
    }

}
