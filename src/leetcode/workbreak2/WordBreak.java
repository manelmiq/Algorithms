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


    private Set<String> wordSet;
    private List<String> results;

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Initialize global objects
        wordSet = new HashSet<>(wordDict);
        results = new ArrayList<>();
        // Start the backtracking process
        backtrack(s, new StringBuilder(), 0);
        return results;
    }

    private void backtrack(String s, StringBuilder currentSentence, int startIndex) {
        // If we've reached the end of the string, add the current sentence to results
        if (startIndex == s.length()) {
            results.add(currentSentence.toString().trim());
            return;
        }

        // Iterate over possible end indices
        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String word = s.substring(startIndex, endIndex);
            // If the word is in the set, proceed with backtracking
            if (wordSet.contains(word)) {
                int currentLength = currentSentence.length();
                currentSentence.append(word).append(" ");
                // Recursively call backtrack with the new end index
                System.out.println("current sentence: " + currentSentence.toString());
                backtrack(s, currentSentence, endIndex);
                // Reset currentSentence to its original length
                currentSentence.setLength(currentLength);
            }
        }
    }


}
