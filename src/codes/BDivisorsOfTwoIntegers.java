package codes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class BDivisorsOfTwoIntegers {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer x = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            Integer value = map.get(a);
            if(value == null) {
                value =1;
            }else{
                value++;
            }
            map.put(a, value);
            x = Math.max(a, x);
        }
        int y = Integer.MIN_VALUE;
        for(int i = 1; i <= x; i++){
            if( (x % i) == 0 ){
                map.put( i, map.get(i) - 1 );
            }
        }

        int debug = 1;
        Iterator it = map.entrySet().iterator();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue().equals(1)){
                y = Math.max(y, entry.getKey());
            }
        }
        out.println(x + " "  + y);

    }
}
