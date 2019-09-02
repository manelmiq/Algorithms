//package codes;
//
//import java.util.*;
//import java.io.PrintWriter;
//
//public class LeaderBoard {
//    public void solve(int testNumber, Scanner in, PrintWriter out) {
//        int s = in.nextInt();
//        int[] ss = new int[s];
//        for (int i = 0; i < s; i++) {
//            ss[i] = in.nextInt();
//        }
//        int a = in.nextInt();
//        int aa[] = new int[a];
//        for (int i = 0; i < a; i++) {
//            aa[i] = in.nextInt();
//        }
//        out.println(Arrays.toString(climbingLeaderboard(ss, aa)));
//
//    }
//
//    int[] climbingLeaderboard(int[] scores, int[] alice) {
//        int[] position = new int[alice.length];
//        int ranking = 2;
//        int curr = scores[0];
//        for (int score : scores) {
//            if (score != curr) {
//                ranking++;
//                curr = score;
//            }
//        }
//        int c = 0;
//        int k = scores.length -1;
//        int current = scores[k];
//        int aliceScore = alice.length - 1;
//        for ( ; k >= 0 ; k--) {
//            if (alice[aliceScore] <= current){
//                position[c++] = ranking;
//            }else{
//                while(k > 0 && current == scores[k]){
//                    k--;
//                }
//                current = scores[k];
//                ranking--;
//            }
//        }
//        return position;
//    }
//
//}
