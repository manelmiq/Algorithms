import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Emmanuell
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskCodility solver = new TaskCodility();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskCodility {
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
                return new int[1];
            }
            if (K == 0) {
                return A;
            }
            int sol[] = new int[A.length];
            System.arraycopy(A, 0, sol, 0, A.length);
            int searchPosition = A.length - (K % A.length);
            int tam = A.length - searchPosition;
            System.arraycopy(A, searchPosition, sol, 0, tam);
            int debug = 1;
            System.arraycopy(A, 0, sol, tam, searchPosition);
            int debug2 = 1;
            return sol;
        }
    }
}

