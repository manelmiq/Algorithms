package leetcode._416;

import java.util.Scanner;
import java.io.PrintWriter;

public class Task {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String line = in.next();
        line = line.substring(1, line.length() - 1);
        String[] items = line.split(",");
        int[] nums = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            nums[i] = Integer.parseInt(items[i]);
        }
        out.println(canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
                }
            }
        }
        return dp[n][subSetSum];
    }
}
