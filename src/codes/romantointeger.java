package codes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.io.PrintWriter;

public class romantointeger {
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
