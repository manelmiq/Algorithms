package leetcode.hard;

import support.Transformation;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class medianSortedArray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int[] arr1 = Transformation.stringToIntegerArray(input);
        String input2 = in.next();
        int[] arr2 = Transformation.stringToIntegerArray(input2);


        int[] nums1 = {1, 3, 4, 6};
        int[] nums2 = {9, 10, 12, 14, 17, 19, 21, 22, 24, 26, 29, 31, 34, 36, 39, 40};

        out.println(findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) { // binary search
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]) { // i is too small, increase i
                iMin = i + 1;
            } else if (i > iMin && nums1[i-1] > nums2[j]) { // i is too big, decrease i
                iMax = i - 1;
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1) { // odd number of elements
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0; // even number of elements
            }
        }
        return 0.0;
    }
}
