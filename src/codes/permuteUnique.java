package codes;

import java.util.*;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class permuteUnique {

    Set<List<Integer>> ans = new HashSet<>();

    public void solve(int testNumber, Scanner in, PrintWriter out) {


        String input = in.next();
        out.println(findDisappearedNumbers(stringToIntegerArray(input)));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] hash = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (hash[i] == 0) {
                list.add(i);
            }
        }
        return list;
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


    public List<List<Integer>> permuteUnique(int[] nums) {
        permute(nums, 0, nums.length - 1);
        List<List<Integer>> uniques = new LinkedList<>(ans);
        return uniques;
    }


    void permute(int[] nums, int l, int r) {
        if (l == r) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = l; i <= r; i++) {
                swap(nums, l, i);
                permute(nums, l + 1, r);
                swap(nums, l, i);

            }
        }
    }


    void swap(int[] list, int l, int r) {
        int temp = list[l];
        list[l] = list[r];
        list[r] = temp;
    }

}
