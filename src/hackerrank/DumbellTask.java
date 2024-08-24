package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class DumbellTask {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        List<Long> freq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            freq.add(in.nextLong());
        }
        out.println(taskOfPairing(freq));
    }

    public static long taskOfPairing(List<Long> freq) {
        long sum = 0;
        for(int i = 0; i < freq.size(); i++) {
            sum += freq.get(i)/2;
            freq.set(i, freq.get(i) % 2); // Use set method to update the list element
            if (i > 0 && freq.get(i - 1) > 0 && freq.get(i) > 0) {
                sum++;
                freq.set(i - 1, 0L); // Use set method to update the list element
            }
        }
        return sum;
    }

}
