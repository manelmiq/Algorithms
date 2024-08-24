package codes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class Task {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] stockPrices = {5, 6, 6, 6, 7, 3};
        out.println(maxProfit(stockPrices));
    }

    int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minDay = 0;
        int maxDay = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minDay = i;
                continue;
            }
            if (prices[i] > prices[minDay]) {
                max = Math.max(prices[i] - prices[minDay], max);
                maxDay = i;
            }
            // System.out.println(max);
        }
        // System.out.println("Min day" + minDay);
        // System.out.println("Max day" + maxDay);
        return (max != Integer.MIN_VALUE) ? max : 0;
    }


}
