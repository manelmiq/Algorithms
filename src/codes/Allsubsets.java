package codes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class Allsubsets {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        String target = in.next();
        int arr[] = stringToIntegerArray(input);
        int targetNumber = Integer.parseInt(target);
        int ans[] = twoSum(arr, targetNumber);
        for(int i = 0; i < ans.length ; i++){
            System.out.print(ans[i]);
        }
//        System.out.println(twoSum(arr, targetNumber));

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
        int res[] = new int[2];
        HashMap<Integer, Integer> complement = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(complement.get( target - nums[i]) != null){
                res[0] = complement.get( target - nums[i]);
                res[1] = i;
                return res;
            }
            complement.put(nums[i] - target, i);
        }

        return null;
    }
}
