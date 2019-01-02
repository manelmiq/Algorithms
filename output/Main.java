import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Emmanuell
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CPowersOfTwo solver = new CPowersOfTwo();
        solver.solve(1, in, out);
        out.close();
    }

    static class CPowersOfTwo {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            Integer k, n;
            n = in.nextInt();
            k = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int power = 1;
            String bits = Integer.toBinaryString(n);
            int cont_digits = 0;
            int ele = 0;
            for (int i = bits.length() - 1; i >= 0; i--, ele++) {
                map.put(ele, bits.charAt(i) - 48);
                cont_digits += (bits.charAt(i) - 48);
            }
            if (cont_digits > k) {
                out.println("NO");
                return;
            }
            while (cont_digits < k) {
                Integer actual = map.get(ele);
                while (actual != null && actual > 0 && map.get(ele - 1) != null) {
                    Integer lower = map.get(ele - 1);
                    lower += 2;
                    actual--;
                    map.put(ele, actual);
                    map.put(ele - 1, lower);
                    cont_digits++;
                    if (cont_digits == k) {
                        break;
                    }
                }
                ele--;
                if (ele == 0) {
                    break;
                }
            }
            if (cont_digits < k) {
                out.println("NO");
                return;
            }

            out.println("YES");
            int print = 0;
            for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
                int times = entry.getValue();
                while (times > 0) {
                    if (print > 0) out.print(" ");
                    out.print((int) Math.pow(2, entry.getKey()));
                    print++;
                    times--;
                }

            }
            out.println();
        }

    }
}

