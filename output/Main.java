import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Emmanuell
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        _472 solver = new _472();
        solver.solve(1, in, out);
        out.close();
    }

    static class _472 {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String line = in.next();
            line = line.substring(1, line.length() - 1);
            String[] items = line.split(",");
            List<String> result = findAllConcatenatedWordsInADict(items);
            out.println(result);
        }

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
            final List<String> answer = new ArrayList<>();
            for (final String word : words) {
                final int length = word.length();
                final boolean[] dp = new boolean[length + 1];
                dp[0] = true;
                for (int i = 1; i <= length; ++i) {
                    for (int j = (i == length ? 1 : 0); !dp[i] && j < i; ++j) {
                        dp[i] = dp[j] && dictionary.contains(word.substring(j, i));
                    }
                }
                if (dp[length]) {
                    answer.add(word);
                }
            }
            return answer;
        }

    }
}

