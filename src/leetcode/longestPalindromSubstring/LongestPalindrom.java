package leetcode.longestPalindromSubstring;

import java.util.Scanner;
import java.io.PrintWriter;

public class LongestPalindrom {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        out.println(longestPalindrome(s));
    }

//    "babad"
    public String longestPalindrome(String s) {
//        dynamic programming where you store initially
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
//        store diagonal

        int begin = 0;
        int maxLength = 1;
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
//        check for all sizes 2
        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                begin = i;
                maxLength = 2;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        begin = i;
                        maxLength = len;
                    }
                }
            }
        }
        return s.substring(begin, maxLength + 1);
    }

}