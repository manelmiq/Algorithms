package leetcode.workbreak2;

import java.util.*;
import java.io.PrintWriter;

public class WordBreak {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        String dictionaryLine = in.next();
        String dic = dictionaryLine.substring(1, dictionaryLine.length() - 1);
        dic = dic.replace("\"", "");
        String[] items = dic.split(",");
        out.println(wordBreak(s, Arrays.asList(items)));
    }


    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, 0, new HashMap<>());

    }

    private List<String> backtrack(String s, List<String> wordDict, int index, Map<Integer, List<String>> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        List<String> result = new ArrayList<>();

        if (index == s.length()) {
            result.add("");
            return result;
        }

        for (int end = index + 1; end <= s.length(); end++) {
            String substring = s.substring(index, end);
            if (wordDict.contains(substring)) {
                List<String> subResult = backtrack(s, wordDict, end, memo);
                for (String str : subResult) {
                    result.add(substring + (str.isEmpty() ? "" : " ") + str);
                }
            }
        }
        memo.put(index, result);
        return result;
    }


}
