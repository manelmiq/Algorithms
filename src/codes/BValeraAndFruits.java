package codes;

import java.util.*;
import java.io.PrintWriter;


public class BValeraAndFruits {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] fruits = new int[200000];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a, b;
            a = in.nextInt();
            b = in.nextInt();
            fruits[a] += b;
        }

        for (int i = 0; i < 3010; i++) {
            int colheta_diaria = k;
            if (i > 0 && fruits[i - 1] > 0) {
                int num = Math.min(colheta_diaria, fruits[i - 1]);
                fruits[i - 1] -= num;
                colheta_diaria -= num;
                ans += num;
            }
            if (colheta_diaria > 0) {
                int num = Math.min(colheta_diaria, fruits[i]);
                fruits[i] -= num;
                colheta_diaria -= num;
                ans += num;
            }
        }

        out.println(ans);
    }
}
