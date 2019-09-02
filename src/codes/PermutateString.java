package codes;

import java.util.*;
import java.io.PrintWriter;

public class PermutateString {

    ArrayList<String> list = new ArrayList<>();

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        out.println(getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        k--;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = (k / fact);
            sb.append(num.remove(index));
            k -= index * fact;
        }
        return sb.toString();
        /*

        char[] v = new char[n];
        char begin = '1';
        for (int i = 0; i < n; i++) {
            v[i] = begin;
            begin++;
        }
        permute(v, 0, n - 1);
        Collections.sort(list);
        return list.get(k - 1);
        *
         */
    }

    void permute(char[] s, int l, int r) {
        if (l == r)
            list.add(String.valueOf(s));
        else {
            for (int i = l; i <= r; i++) {
                swap(s, l, i);
                permute(s, l + 1, r);
                swap(s, l, i);
            }
        }
    }

    private char[] swap(char[] arr, int i, int j) {
        char temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


}



























