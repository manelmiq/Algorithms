package leetcode;

import support.Transformation;

import java.util.Scanner;
import java.io.PrintWriter;

public class Leetcode122BestTime {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int[] prices = Transformation.stringToIntegerArray(input);
        out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
