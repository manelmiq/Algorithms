package leetcode._426_Concatend_words;

import java.util.*;
import java.io.PrintWriter;

public class Task {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        input = input.substring(1, input.length() - 1);
        String[] words = input.split(",");
        List<String> result = findAllConcatenatedWordsInADict(words);
        out.println(result);
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<String> concatenatedWords = new ArrayList<>();

        for (String word : words) {
            wordSet.remove(word);
            if (canForm(word, wordSet)) {
                concatenatedWords.add(word);
            }
            wordSet.add(word);
        }

        return concatenatedWords;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        if (word.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }


}
