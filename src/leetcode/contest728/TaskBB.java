package leetcode.contest728;

import java.util.Scanner;
import java.io.PrintWriter;

class TaskBB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while(t > 0){
            t--;
            int n = in.nextInt();
            int[] v = new int[n];
            for(int i = 0; i < n; i++){
                v[i] = in.nextInt();
            }
            int ans = 0;
            for(int i = 0; i < n; i++){
                for(int j = 1; i < n; j++){
                    int sum = i + j;
                    int mult = v[i] * v[j];
                    if(sum == mult){
                        ans++;
                    }
                }
            }
            out.println(ans);
        }
    }
}
