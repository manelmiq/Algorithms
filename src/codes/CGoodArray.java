package codes;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;


public class CGoodArray {

    int index;
    int value;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        long sum = 0;
        long[] v = new long[n];
        long max = -1;
        long seconMax = -1;
        LinkedList<CGoodArray> input = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            v[i] = in.nextLong();
            if(v[i] > max){
                seconMax = max;
                max = v[i];
            }else if(v[i] > seconMax ){
                seconMax = v[i];
            }
            sum += v[i];
        }
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++){
            long search = sum - v[i] ;
            if(v[i] == max){
                search -= seconMax;
                if(search == seconMax){
                    ans.add(i + 1);
                }
            }else {
                search -=  max;
                if (search == max) {
                    ans.add(i + 1);
                }
            }
        }
        if(ans.isEmpty()){
            out.println(0);
            return;
        }
        out.println(ans.size());

        for(int i = 0; i < ans.size(); i++){
            out.print(ans.get(i) + " ");
        }
    }
}
