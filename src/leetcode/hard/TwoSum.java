package leetcode.hard;

import codes.Allsubsets;

import java.util.Scanner;
import java.io.PrintWriter;

import static codes.Allsubsets.stringToIntegerArray;


public class TwoSum {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int arr[] = Allsubsets.stringToIntegerArray(input);
        String nums2 = in.next();
        int debug = 1;
//        int target = in.nextInt();
//        int[] nums1 = stringToIntegerArray(nums);
        out.println("Input"  + arr );
        out.println("Nums2"  + nums2 );
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }


    public int[] twoSum(int[] nums, int target) {

        return null;
    }

}
