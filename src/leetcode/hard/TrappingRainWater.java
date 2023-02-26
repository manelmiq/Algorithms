package leetcode.hard;


import java.util.Scanner;
import java.io.PrintWriter;

import static dataStructures.LinkedList.MainClass.stringToIntegerArray;
import static dataStructures.LinkedList.MainClass.stringToListNode;

public class TrappingRainWater {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] height = stringToIntegerArray(in.next());
        out.println(trap(height));
    }

    public int trap(int[] height) {
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < height.length; i++){
            int dropInPosition =  calculateMaxDrop(i, height);
            result += dropInPosition;
            System.out.println(i + "->" + result);
        }
        return result;
    }

    public int calculateMaxDrop(int position, int height[]) {
        int leftIterator = position - 1;
        int rightIterator = position  + 1;
        int leftMax = height[position];
        int rightMax = height[position];
        for ( ; (leftIterator >= 0) || (rightIterator < height.length) ; leftIterator--, rightIterator ++){
            if(leftIterator >= 0){
                leftMax = Math.max(height[leftIterator], leftMax);
            }
            if(rightIterator < height.length){
                rightMax = Math.max(height[rightIterator], rightMax);
            }
        }
//        int result = Math.min(leftMax, rightMax) - height[position];
        return  Math.max(0, Math.min(leftMax, rightMax) - height[position]);
    }
}
