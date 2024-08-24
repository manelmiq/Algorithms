package codes;

import java.util.*;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            String input = in.next();

            // Array to count occurrences of 'A' to 'F'
            int[] count = new int[7];
            for (char c : input.toCharArray()) {
                if (c >= 'A' && c <= 'G') {
                    count[c - 'A']++;
                }
            }

            int ans = 0;
            for (int i = 0; i <= 6; i++) {
                if (count[i] < m) {
                    ans += (m - count[i]);
                }
            }
            out.println(ans);
        }
    }
}
