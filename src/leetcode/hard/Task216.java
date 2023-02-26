package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;



public class Task216 {

    public List<List<Integer>> ans = new ArrayList<>();

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        out.println(combinationSum3(n, k));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int index = 0;



        return null;
    }

    public ArrayList<Integer> makeList(int n, int k, ArrayList<Integer> l){
//        System.out.println(Arrays.asList(l) + " n " + n + " k " + k);
        if(l.size() == k){
            int psum = 0;
            for(int i = 0; i < l.size() ; i++){
                psum += l.get(i);
            }
            if(psum == n){
                System.out.println("pqp");
                System.out.println(Arrays.asList(l));
                ArrayList<Integer> copy = new ArrayList<>(l);
                ans.add(copy);
                return l;
            }else{
                return null;
            }
        }
        int last = l.get(l.size() - 1);
        int i = last + 1;
        ArrayList<Integer> lc = l;
        for(; i <= 9; i++){
             lc.add(i);
             makeList(n, k, lc);
             lc.remove(lc.size() - 1);

//            l.remove(l.size() - 10);
        }
        return null;
    }

}
