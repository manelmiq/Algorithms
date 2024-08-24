import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
        LongestSubstring solver = new LongestSubstring();
        solver.solve(1, in, out);
        out.close();
    }

    static class LongestSubstring {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.next();
            out.println(lengthOfLongestSubstring(s));
        }

        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }

            int result = 0;
            Set<Character> set = new HashSet<>();
            int start = 0;

            for (int end = 0; end < s.length(); end++) {
                while (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(s.charAt(end));
                result = Math.max(result, end - start + 1);
            }

            return result;
        }

    }
}

