package codes;

import support.Transformation;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;


public class MergeSort {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int[] arr = Transformation.stringToIntegerArray(input);
        mergeSort(arr, 0, arr.length - 1);
        out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(nums, left, middle);
            mergeSort(nums, middle + 1, right);
            merge(nums, left, middle, right);
        }
    }

    private void merge(int[] nums, int left, int middle, int right) {
        /* Merge the temp arrays back into arr[l..r]*/
        // Initial index of first subarray
        // Initial index of second subarray
        // Initial index of merged subarray
        int i, j, k = left;
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = nums[left + i];
        for (j = 0; j < n2; j++)
            R[j] = nums[middle + 1 + j];
        i = 0;
        j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1) {
            nums[k++] = L[i++];
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2) {
            nums[k++] = R[j++];
        }
    }
}
