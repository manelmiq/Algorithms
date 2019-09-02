package codes;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class OuterMostParentheses {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        out.println(removeOuterParentheses(s));
    }

    private String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        int len = s.length();
        int begin =  0;
        int countOpen = 0;
        int countClose = 0;
        for(int i = 0; i < len; i++){
           countOpen += (s.charAt(i) == ')') ? 1 : 0;
           countClose += (s.charAt(i) == '(') ? 1 : 0;
           if(countClose == countOpen){
               str.append(s, begin + 1, i );
               countClose = 0;
               countOpen = 0;
               begin = i + 1;
           }
        }
        System.out.println(str.toString());
        return str.toString();
    }
}
