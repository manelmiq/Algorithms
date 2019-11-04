package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class IsPalindrom {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        out.println(cointainsPalindrom(input));
    }

    boolean isPalindrom(String s) {
        int pointerBegin = 0;
        int pointerEnd = s.length() - 1;
        for (; pointerBegin < pointerEnd; pointerBegin++, pointerEnd--) {
            if (s.charAt(pointerBegin) != s.charAt(pointerEnd)) {
                return false;
            }
        }
        return true;
    }

    boolean cointainsPalindrom(String s) {
        int pointerBegin = 0;
        int pointerEnd = s.length() - 1;
        for (; pointerBegin < pointerEnd; pointerBegin++, pointerEnd--) {
            if (s.substring(pointerBegin, pointerEnd).length() > 2) {
//                boolean checkSubString = isPalindrom(s.substring(i, j));
//                if (checkSubString) {
//                    return checkSubString;
//                }
            }
        }
        return false;
    }
}
