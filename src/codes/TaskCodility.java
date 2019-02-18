package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskCodility {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
        }
        int t[] = solution(v, k);
        for (int i = 0; i < t.length; i++) {
            if (i > 0)
                out.print(" ");
            out.print(t[i]);
        }
    }

    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return new int[0];
        }
        if (K == 0) {
            return A;
        }
        int sol[] = new int[A.length];
        System.arraycopy(A, 0, sol, 0, A.length);
        int searchPosition = A.length - (K % A.length);
        int tam = A.length - searchPosition;
        System.arraycopy(A, searchPosition, sol, 0, tam);
        System.arraycopy(A, 0, sol, tam, searchPosition);
        return sol;
    }
}
