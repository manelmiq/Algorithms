package leetcode.medium;

import java.util.*;
import java.io.PrintWriter;

import static support.Transformation.stringToIntegerArray;

public class Building {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int[] inputArr = stringToIntegerArray(input);
        out.println(Arrays.toString(findBuildings(inputArr)));
    }

    public int[] findBuildings(int[] heights) {
        if(heights.length == 1){
            int[] ans = new int[1];
        }
        int[] ans = new int[heights.length];
        List<Integer> building = new ArrayList<>();
        building.add(heights.length - 1);
        int maxCurrentHeight = heights[heights.length - 1];
        for (int i = heights.length - 2 ; i >= 0; i--) {
            if(maxCurrentHeight < heights[i]){
                building.add(0, i);
            }
            maxCurrentHeight = Math.max(maxCurrentHeight, heights[i]);
        }
        int[] toArray = new int[building.size()];
        int j = 0;
        for(int c : building){
            toArray[j++] = c;
        }
        return toArray;
    }
}
