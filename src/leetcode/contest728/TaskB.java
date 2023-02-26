package leetcode.contest728;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while(t > 0){
            t--;
            int n = in.nextInt();
            int[] v = new int[n];
            int ans = 0;
            for(int i = 0; i < n; i++){
                v[i] = in.nextInt();
                for(int j = i - 1; j >= 0;j--){
                    if(j > 0 ){

                    }
                }

            }

            for(int i = (n - 1); i >= 1; i--){
                for(int j = i - 1; j >= 0; j--){

                }
            }
            out.println(ans);
        }
    }
}
