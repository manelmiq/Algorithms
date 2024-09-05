package leetcode._1877;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class _1877 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String line = in.next();
        line = line.substring(1, line.length() - 1);
        String[] items = line.split(",");
        int[] nums = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            nums[i] = Integer.parseInt(items[i]);
        }
        out.println(minPairSum(nums));

    }

    public int minPairSum(int[] nums) {
        int min = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            min = Math.max(min, nums[left] + nums[right]);
            left++;
            right--;
        }

        return min;
    }
}
