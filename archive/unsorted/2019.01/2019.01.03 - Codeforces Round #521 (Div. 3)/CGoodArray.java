package codes;

import javax.swing.*;
import java.util.*;
import java.io.PrintWriter;

public class CGoodArray {


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int sum = 0;
        int max = -1;
        int seconMax = -1;
        HashMap<Integer, ArrayList<Integer> > indexes = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            indexes.putIfAbsent(a, new ArrayList<Integer>());
            indexes.get(a).add(i + 1);
            if(a > max){
                max = a;
            }else if(a > seconMax ){
                if(a != max){
                    seconMax = a;
                }
            }
            sum += a;
        }
        int debug  = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        Integer search1 = sum - 2*max;
        Integer search2 = sum - 2*seconMax;
        
        if(indexes.get(search1) != null ) {
            if(search1 == max){
                if(indexes.get(search1).size() > 1){
                    ans.addAll(indexes.get(search1));
                }
            }else{
                ans.addAll(indexes.get( search1));
            }
        }

        if(seconMax != -1){
            if(indexes.get(search2) != null  )
                ans.addAll(indexes.get(search2));
        }


        if(ans.isEmpty()){
            out.println("0");
            return;
        }
        out.println(ans.size());
        Iterator<Integer> it = ans.iterator();
        while(it.hasNext()){
            out.print(it.next() + " ");
        }





    }
}
