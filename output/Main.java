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
        AIntegerSequenceDividing solver = new AIntegerSequenceDividing();
        solver.solve(1, in, out);
        out.close();
    }

    static class AIntegerSequenceDividing {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long n = in.nextLong();
            long sum = n * (n + 1) / 2;
            if ((sum % 2 == 1)) {
                out.println(1);
            } else {
                out.println(0);
            }
        }

    }
}

