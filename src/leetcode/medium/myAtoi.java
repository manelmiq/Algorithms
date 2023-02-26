package leetcode.medium;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class myAtoi {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input;
        while(in.hasNext()){
            out.println(myAtoi(in.next()));
        }
    }
    public int myAtoi(String s) {
//        System.out.println("test Case");
        if(s == "" || s == null || s.isEmpty()){
            return 0;
        }
        long num = 0;
        int numInt = 0;
        long digit = 1;
        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }
        String[] splits = s.split(" ");
//        System.out.println(Arrays.toString(splits));
        if(splits.length > 0){
            s = splits[0];
        }
        boolean isNegative = false;
        char first = s.charAt(0);
        if(first == '-'){
            isNegative = true;
//            System.out.println("isNegative");
            s = s.substring(1, s.length());
            digit *= (-1);

        }else if(first == '+'){
            s = s.substring(1, s.length());
        }
        if(s.isEmpty()){
            return 0;
        }
        String[] commasSplit = s.split("\\.");
        if(commasSplit.length> 0){
            s = commasSplit[0];
        }
//        System.out.println("num before string builder" + num);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                if(s.charAt(i) == '0' && str.length() == 0){
                    continue;
                }else{
                    str.append(s.charAt(i));
                }

            }else{
                break;
            }
        }
//        System.out.println("num before loop" + num);
        s = str.toString();
        if(s.length() > 10){
            return (isNegative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        for(int i = s.length() - 1; i >= 0 ; --i){
            if(!Character.isDigit(s.charAt(i))){
                return 0;
            }
            num += (s.charAt(i) - '0') * digit;
            digit *= 10;
        }
//        System.out.println("num before " + num);
        if(num   > Integer.MAX_VALUE){
//            System.out.println("explode to max");
            return Integer.MAX_VALUE ;
        }else if(num < Integer.MIN_VALUE){
//            System.out.println("explode to min");
            return Integer.MIN_VALUE;
        }

//        System.out.println(num);
        numInt = (int) num;

        return  numInt;
    }
}
