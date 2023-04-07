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
        out.println(findMedianSortedArrays(arr1, arr2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
             int size = nums1.length + nums2.length;

//        odd number
//        int begin1 = ((nums1.length) / 2) - 1;
//        starRangeIn1 = Math.max(starRangeIn1, 0);
//        int startRangeIn2 = ((nums2.length) / 2) - 1;
//        startRangeIn2 = Math.max(startRangeIn2, 0);
//        int currentPos = 0;
//        if ((size % 2) == 1) {
//            int medianIndexTarget = (size / 2) + 1;
//            while(currentPos != medianIndexTarget){
//                int middle1 = nums1[]
//                if(nums1[starRangeIn1){
//
//                }
//            }
//        }
        return 0;
    }

    public int lowestInRange(int[] nums1, int begin, int end, int target) {
       int middle = (begin + end) / 2;
       if(begin >= end){
           if(end < 0){
               return end;
           }
           return begin;
       }
       if(nums1[middle] == target){
           return middle;
       }else if(nums1[middle] > target){
           end = middle - 1;
       }else{
           begin = middle + 1;
       }
       return lowestInRange(nums1, begin, end, target);
    }
}
