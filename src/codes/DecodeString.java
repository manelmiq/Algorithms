package codes;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class DecodeString {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();

        out.println(decodeString(input));

    }


    public void printStack(LinkedList<String> stack){
        for(int i = 0; i < stack.size(); i++){
            System.out.println(stack.get(i));
        }
    }



    public String stackToString(LinkedList<String> stack){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
           str.insert( 0, stack.get(i));
        }
        return  str.toString();
    }

    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ']') {
//                System.out.println("need to pop");
                StringBuilder current = new StringBuilder();
                StringBuilder times = new StringBuilder();
                while (!stack.isEmpty()) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            times.insert(0, stack.pop());
                        }
                        System.out.println("times" + times);
                        System.out.println("current [" + current+"]");
                        StringBuilder multiple = new StringBuilder();
                        for(int k = 0;  k < Integer.parseInt(times.toString()); k++){
                            multiple.append(current.toString());
                        }
//                        str.append(current);
                        stack.push(multiple.toString());
//                        str.append(multiple);

//                        System.out.println(times);
//                        System.out.println(current);
                        break;
                    }
                    current.insert(0, stack.pop());
                }
//                System.out.println("fim do pop");
            } else {
                stack.push(s.charAt(i)+ "");
            }
        }
//        System.out.println();
        return stackToString(stack);
    }
}
