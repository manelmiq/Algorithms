package leetcode.medium;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import static dataStructures.LinkedList.MainClass.stringToIntegerArray;

public class SortColors {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] height = stringToIntegerArray(in.next());
        out.println(Arrays.toString(sortColors(height)));
    }

    public int[] sortColors(int[] nums) {
        int aux;
        if(nums.length == 1){
            return nums;
        }
        if(nums.length == 2){
            if(nums[0] > nums[1]){
                aux = nums[0];
                nums[0] = nums[1];
                nums[1] = aux;
            }
            return nums;
        }
        int low = nums.length -1;
        int big = 0;
        for( big = 0; big < nums.length ; big++){
            if(big >= low){
                break;
            }
            if(nums[big] == 2){
                while(low > 0 && nums[low] == 2 && big < low){
                    low--;
                }
                nums[big] = nums[low];
                nums[low] = 2;
            }
        }

        return nums;
    }

}
