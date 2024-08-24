package codes;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2696 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        out.println(minLength(input));
    }

    public int minLength(String s) {
        String pattern = "AB|CD";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        while (m.find()) {
            s = s.replaceAll(pattern, "");
            m = p.matcher(s);
        }
        return s.length();
    }
}
