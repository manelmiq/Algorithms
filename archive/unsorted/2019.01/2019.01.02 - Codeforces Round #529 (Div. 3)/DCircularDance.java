package codes;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;

public class DCircularDance {
    private static int[][] rules;
    private static int n;

    public int nextToadd(int first, int next) {
        int add = -1;
        if (rules[first][0] == next) {
            add = rules[first][1];
        } else if (rules[first][1] == next) {
            add = rules[first][0];
        }
        return add;
    }

    public ArrayList<Integer> buildList(int first, int next) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(first);
        ans.add(next);
        while (ans.size() != n) {
            int nextToAdd = nextToadd(first, next);
            if (nextToAdd == -1) {
                return null;
            }
            ans.add(nextToAdd);
            first = next;
            next = nextToAdd;
        }

        return ans;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        rules = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            rules[i][0] = in.nextInt();
            rules[i][1] = in.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans = buildList(1, rules[1][0]);
        if (ans == null) {
            ans = buildList(1, rules[1][1]);
        }
        for (int i = 0; i < n; i++) {
            out.print(ans.get(i) + " ");
        }
        out.println();


    }
}
