package leetcode.easy;

import java.util.HashMap;
import java.util.Scanner;
import java.io.PrintWriter;

public class VerifyAlienDictionary {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] words = line.split(",");
            String order = in.nextLine();
            out.println(isAlienSorted(words, order));
        }
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> weigth = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            weigth.put(order.charAt(i), i);
        }
        String previous = words[0];
        for (int i = 1; i < words.length; i++) {
            int great = isGreat(words[i], previous, weigth);
//            System.out.println("great " + great);
            if (great < 0) {
                return false;
            }
            previous = words[i];
        }
        return true;
    }

    public int isGreat(String a, String b, HashMap<Character, Integer> hashMap) {
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            int difference = hashMap.get(a.charAt(i)) - hashMap.get(b.charAt(i));
            if (difference != 0) {
                return difference;
            }
        }
        return a.length() - b.length();
    }
}



