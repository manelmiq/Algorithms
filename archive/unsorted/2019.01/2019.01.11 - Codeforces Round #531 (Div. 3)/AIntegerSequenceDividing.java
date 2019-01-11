package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class AIntegerSequenceDividing {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        long sum = n*(n + 1)/ 2;
        if((sum % 2 == 1)){
            out.println(1);
        }else{
            out.println(0);
        }
    }
}
