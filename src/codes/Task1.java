package codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.Stream;

public class Task1 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(solution("x", 999997));
    }

    static long solution(String s, int k) {
        int size = Integer.valueOf(s.length());
        int r = k % size;
        double div = (double) k / size;
        if (r == 0){
            return (int) div;
        }
        return (int) Math.ceil(div);
    }


}
