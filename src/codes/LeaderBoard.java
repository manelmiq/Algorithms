package codes;

import java.util.*;
import java.io.PrintWriter;

public class LeaderBoard {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int s = in.nextInt();
        int[] ss = new int[s];
        for (int i = 0; i < s; i++) {
            ss[i] = in.nextInt();
        }
        int a = in.nextInt();
        int aa[] = new int[a];
        for (int i = 0; i < a; i++) {
            aa[i] = in.nextInt();
        }
        int[] ret = climbingLeaderboard(ss, aa);
        for (int i = 0; i < ret.length; i++) {
            out.println(ret[i]);
        }
    }


    int[] climbingLeaderboard(int[] scores, int[] alice) {
        HashMap<Integer, Integer> classification = new HashMap<>();
        int[] position = new int[alice.length];
        int positionIndex = alice.length - 1;
        int scoreIndex = 0;
        LinkedList<Integer> scoresList = new LinkedList<>();
        int curr = scores[0];
        scoresList.add(curr);
        // Get rid of duplicates
        for (int score : scores) {
            if (score != curr) {
                curr = score;
                scoresList.add(curr);
            }
        }
        int rank = 1;
        for (int j = (alice.length - 1); j >= 0; ) {
            if (scoresList.isEmpty()) {
                position[positionIndex--] = rank;
                j--;
                continue;
            }
            if (alice[j] >= scoresList.peekFirst()) {
                position[positionIndex--] = rank;
                j--;
            } else {
                scoresList.removeFirst();
                rank++;
            }
        }
        return position;
    }

}
