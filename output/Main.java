import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;

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
        romantointeger solver = new romantointeger();
        solver.solve(1, in, out);
        out.close();
    }

    static class romantointeger {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String n = in.next();
            out.println(romanToInt(n));
        }

        public int romanToInt(String s) {
            HashMap<Character, Integer> romanSymbols = new HashMap<>();
            romanSymbols.put('I', 1);
            romanSymbols.put('V', 5);
            romanSymbols.put('X', 10);
            romanSymbols.put('L', 50);
            romanSymbols.put('C', 100);
            romanSymbols.put('D', 500);
            romanSymbols.put('M', 1000);
            int converted = 0;

            for (int i = 0; i < s.length(); i++) {
                int current = romanSymbols.get(s.charAt(i));
                int next = 0;
                if (i < (s.length() - 1)) {
                    next = romanSymbols.get(s.charAt(i + 1));
                }
                if (current < next) {
                    converted -= current;
                } else {
                    converted += current;
                }
            }
            return converted;
        }

    }
}

