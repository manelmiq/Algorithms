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
        LongestPalindrom solver = new LongestPalindrom();
        solver.solve(1, in, out);
        out.close();
    }

    static class LongestPalindrom {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.next();
            out.println(longestPalindrome(s));
        }

        public String longestPalindrome(String s) {
//        dynamic programming where you store initially
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
//        store diagonal
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
//        check for all sizes 2
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = true;
                }
            }
            int begin = 0;
            int end = 0;
            int maxLength = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 2; j < n; j++) {
                    if ((i - 1) >= 0 && ((j - 1) < n)
                            && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if ((j - i) > maxLength) {
                            maxLength = j - i;
                            begin = i;
                            end = j;
                        }
                    }
                }
            }
            return s.substring(begin, end + 1);
        }

    }
}

