package codes;

import java.util.*;
import java.io.PrintWriter;

public class BArrayStabilization {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        Integer great , secGreat , low , secLowest;
        for(int i = 0; i < n; i++){
            Integer a  = in.nextInt();
            arr.add(a);
        }
        Collections.sort(arr);
        out.println(Math.min( arr.get(n - 1) - arr.get(1)  , arr.get(n - 2)  - arr.get(0)));
    }





}
