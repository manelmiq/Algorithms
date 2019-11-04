package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class AGennadyAndACardGame {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String card = in.next();
        boolean found = false;
        for (int i = 0; i < 5; i++) {
            String table = in.next();
            if (card.charAt(1) == table.charAt(1) || card.charAt(0) == table.charAt(0)) {
                found = true;
            }
        }
        if (found) {
            out.println("YES");
        } else {
            out.println("NO");
        }

    }
}
