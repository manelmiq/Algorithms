package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class StockProblem {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

    }


    public static int findPositionToReplace(int[] a, int low, int high, int x) {
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null | nums.length == 0)
            return 0;
        int n = nums.length, len = 0;
        int[] increasingSequence = new int[n];
        increasingSequence[len++] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > increasingSequence[len - 1])
                increasingSequence[len++] = nums[i];
            else {
                int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
                increasingSequence[position] = nums[i];
            }
        }
        return len;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target > nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
