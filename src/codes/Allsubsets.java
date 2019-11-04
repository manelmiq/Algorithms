package codes;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class Allsubsets {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int arr[] = stringToIntegerArray(input);

        System.out.println(subsets(arr));

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

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            LinkedList<Integer> ans = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                int result = (i & (1 << j));
                System.out.println("i " + result);
                if ((i & (1 << j)) > 0) {
                    ans.add(nums[j]);
//                    System.out.print(nums[j] + " ");
                }
            }
            list.add(ans);
            System.out.println("___");
            // (1<<j) is a number with jth bit 1
            // so when we 'and' them with the
            // subset number we get which numbers
            // are present in the subset and which
            // are not
        }
        return list;
    }
}
