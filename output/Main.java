package output;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

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
        FraudelentActivity solver = new FraudelentActivity();
        solver.solve(1, in, out);
        out.close();
    }

    static class FraudelentActivity {
        public int calculateMedianDouble(int[] appCounter, int listSize) {
            int initialCount = (listSize / 2);
            if ((listSize % 2) == 1) {
                for (int i = 0; i <= 200; i++) {
                    initialCount -= appCounter[i];
                    if (initialCount <= 0) {
                        return i * 2;
                    }
                }
            } else {
                int firstMedian = 0;
                for (int i = 0; i <= 200; i++) {
                    initialCount -= appCounter[i];
                    if (initialCount > 0) {
                        continue;
                    } else if (initialCount == 0) {
                        firstMedian = i;
                        while (appCounter[++i] == 0) {
                            i++;
                        }
                        return firstMedian + i;
                    } else {
                        return i * 2;
                    }
                }
            }
            return 0;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int d = in.nextInt();
            List<Integer> expenditure = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int it = in.nextInt();
                expenditure.add(it);
            }
            int[] list = {0, 1, 3};
            int[] list1 = {0, 1, 3, 0, 1};
            int[] list2 = {0, 0, 3, 3, 0};
//        out.println(calculateMedianDouble(list, 4));
//        out.println(calculateMedianDouble(list1, 5));
//        out.println(calculateMedianDouble(list2, 6));
            out.println(activityNotifications(expenditure, d));

        }

        public int activityNotifications(List<Integer> expenditure, int d) {
            // Write your code here
            int noti = 0;
            List<Integer> queue = new ArrayList<>(expenditure.subList(0, d));
            Iterator<Integer> iterator = expenditure.iterator();
            int[] countAppears = new int[201];
            for (int i = 0; i < d; i++) {
                int current = iterator.next();
                countAppears[current]++;
            }
            while (iterator.hasNext()) {
                int current = iterator.next();

                if (calculateMedianDouble(countAppears, d) <= current) {
                    noti++;
                }
                countAppears[current]++;
                int queueFirst = queue.get(0);
                countAppears[queueFirst]--;
                queue.remove(0);
                queue.add(current);
            }
            return noti;
        }

    }
}

