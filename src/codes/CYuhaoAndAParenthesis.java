package codes;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.io.PrintWriter;

public class CYuhaoAndAParenthesis {

    boolean check(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
//        for()
    }
}
