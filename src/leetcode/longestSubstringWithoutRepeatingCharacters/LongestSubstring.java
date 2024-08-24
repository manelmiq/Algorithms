package leetcode.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class LongestSubstring {
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
