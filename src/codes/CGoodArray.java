package codes;



import javax.swing.*;
import java.util.*;
import java.io.PrintWriter;

public class CGoodArray {


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] nums = new int[2000001];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            sum += a;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer> > ee : indexes){

        }


        Iterator<Integer> it = ans.iterator();
        while(it.hasNext()){
            out.print(it.next() + " ");
        }





    }
}
