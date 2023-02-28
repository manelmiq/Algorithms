package leetcode.medium;

import java.util.*;
import java.io.PrintWriter;

import static support.Transformation.stringToStringArray;

public class Task {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        groupAnagrams(stringToStringArray(s));
        out.println(groupAnagrams(stringToStringArray(s)).toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hash = new HashMap<>();
        for(String current : strs){
            char[] copy = current.toCharArray();
            Arrays.sort(copy);
            List<String> list = hash.getOrDefault(Arrays.toString(copy), new ArrayList<>());
            list.add(current);
            hash.put(Arrays.toString(copy), list );
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> current : hash.entrySet()){
            result.add(current.getValue());
        }
        return result;
    }
}
