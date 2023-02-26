package codes;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskAB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        while(t > 0){
            t--;
            int n = in.nextInt();
            int nn = n;
            for(int i = 0; i < n; i++){
                if(i == 0){
                    out.print(nn);
                    nn = 1;
                }else{
                    out.print(" " + nn);
                    nn++;
                }
            }
            out.println();
        }
    }
}
