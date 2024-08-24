//package hackerrank;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.io.PrintWriter;
//
//public class MaxSubArrayValue {
//    public void solve(int testNumber, Scanner in, PrintWriter out) {
//        int n = in.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = in.nextInt();
//        }
//        out.println(maxSubarrayValue(Arrays.asList(arr));
//    }
//    public static long maxSubarrayValue(List<Integer> arr) {
//        // Write your code here
//        int n = arr.size();
//        long maxValue = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int evenSum = 0;
//                int oddSum = 0;
//
//                for (int k = i; k <= j; k++) {
//                    if ((k - i) % 2 == 0) {
//                        evenSum += arr.get(k);
//                    } else {
//                        oddSum += arr.get(k);
//                    }
//                }
//
//                int value = (evenSum - oddSum) * (evenSum - oddSum);
//                maxValue = Math.max(maxValue, value);
//            }
//        }
//
//        return maxValue;
//
//    }
//}
