package codes;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;


public class ARepeatingCipher {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        String s  = in.next();
        for(int i = 0, k = 1; i < n; k++, i+= k){
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }
}
