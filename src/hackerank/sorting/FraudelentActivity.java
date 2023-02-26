package hackerank.sorting;


import java.io.*;
import java.util.*;

public class FraudelentActivity {

//9 5
//        2 3 4 2 3 6 8 4 5

    public static int findMedianTimes2(int[] subCountArray, int d) {
        int count = 0;
        boolean isOdd = (d % 2) != 0;
        // It is variables for when d is an even number.
        int median1 = 0;
        int median2 = 0;

        // Adding the values of the array starting from index 0 is the same as finding the median in a sorted array.
        for (int i = 0; i < subCountArray.length; i++) {
            count += subCountArray[i];

            if (isOdd && (count >= (d / 2) + 1)) {
                return i * 2;
            } else if (!isOdd) {
                // Be careful. Since median1 should be saved only once, the condition median1 == 0 should be put in.
                // It took me 30 minutes to find this mistake. LAMO
                if (count >= (d / 2) && median1 == 0) {
                    median1 = i;
                } // end of if
                if (count >= (d / 2) + 1) {
                    median2 = i;
                    break;
                } // end of if
            } // end of if-else
        } // end of i

        return median1 + median2;
    } // end of findMedian()

    public int calculateMedianDouble(int[] appCounter, int listSize) {
        int initialCount = (listSize / 2);
        if ((listSize % 2) == 1) {
            for (int i = 0; i <= 200; i++) {
                initialCount -= appCounter[i];
                if (initialCount < 0) {
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

