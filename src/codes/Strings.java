package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class Strings {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        out.println(allInteger(input));
    }

    public Integer allInteger(String s) {
        Integer r = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int digit = 1;
                int partial = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    partial *= 10;
                    partial += (int) (s.charAt(i) - 48);
                    i++;
                }
                r = r + partial;
            } else if (s.charAt(i) == '-') {
                int digit = 1;
                int partial = 0;
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    partial *= 10;
                    partial += (int) (s.charAt(i) - 48);
                    i++;
                }
                r = r - partial;
            }
        }
        return r;
    }


}
