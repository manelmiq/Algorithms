package contests._1538;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskAB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int testCases = in.nextInt();
        while (testCases > 0) {
            testCases--;
            String num = in.next();
            Integer n = Integer.valueOf(num);
            int[] arr = new int[n];
            int minPosition = 0, maxPosition = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (arr[i] < min) {
                    min = arr[i];
                    minPosition = i;
                }
                if (arr[i] > max) {
                    max = arr[i];
                    maxPosition = i;
                }
            }
            int result = 0;
//            if (minPosition <= (n / 2) && maxPosition <= (n / 2)) {
//                result += Math.max(minPosition, maxPosition) + 1;
//            } else if (minPosition >= (n / 2) && maxPosition >= (n / 2)) {
//                result += Math.max((n - maxPosition), (n - minPosition));
//            } else {
                if(minPosition > maxPosition){
                    int temp = minPosition;
                    minPosition = maxPosition;
                    maxPosition = temp;
                }
                result += Math.min(
                        (minPosition + 1 + (n - maxPosition))   ,
                        Math.min(
                                maxPosition + 1, n - minPosition
                        )
                );
//            }
            out.println(result);
        }
    }
}
