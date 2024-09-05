package leetcode._727;

import java.util.Scanner;
import java.io.PrintWriter;

public class _727 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s1 = in.next();
        s1 = s1.substring(1, s1.length() - 1);
        String s2 = in.next();
        s2 = s2.substring(1, s2.length() - 1);
        out.println(minWindow(s1, s2));
    }

    public String minWindow(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (end < s1Length) {
            int s2Index = 0;

            // Move end pointer to find a valid window
            while (end < s1Length) {
                if (s1.charAt(end) == s2.charAt(s2Index)) {
                    s2Index++;
                    if (s2Index == s2Length) break;
                }
                end++;
            }

            // If we didn't find a valid window, break
            if (s2Index != s2Length) break;

            // Move start pointer to minimize the window
            int tempStart = end;
            s2Index = s2Length - 1;
            while (tempStart >= start) {
                if (s1.charAt(tempStart) == s2.charAt(s2Index)) {
                    s2Index--;
                    if (s2Index < 0) break;
                }
                tempStart--;
            }

            // Update the minimum window
            if (end - tempStart < minLength) {
                minLength = end - tempStart;
                minStart = tempStart + 1;
            }

            // Move start to the next character for the next iteration
            start = tempStart + 2;
            end = start;
        }

        return (minLength == Integer.MAX_VALUE) ? "" : s1.substring(minStart - 1, minStart + minLength );
    }
}
