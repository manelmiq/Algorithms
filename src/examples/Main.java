package examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        String S = "sams abbdd  SAM dd  sam..   jj   ..sam  be";
        System.out.println(S);
        String res = Arrays.stream(S.split(" "))
                .map(s -> {
                    StringBuilder str = new StringBuilder();
                    for (int i = 0; i < s.length(); i++) {
                        if ((i + 2) < s.length()) {
                            if (s.toLowerCase().substring(i, i + 3).equals("sam")) {
                                str.append("walmart");
                                i += 2;
                                continue;
                            }
                        }
                        str.append(s.charAt(i));
                    }
                    return str.toString();
                })
                .collect(Collectors.joining(" "));
        System.out.println(res);
    }
}
