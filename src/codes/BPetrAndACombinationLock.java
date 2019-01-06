package codes;

import java.util.*;
import java.io.PrintWriter;

public class BPetrAndACombinationLock {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int sum = 0;

        ArrayList<Integer> possibities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (possibities.isEmpty()) {
                possibities.add(a);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                for (int j = 0; j < possibities.size(); j++) {
                    Integer x = possibities.get(j);
                    list.add((x - a) % 360);
                    list.add((x + a) % 360);
                }
//                out.println(list);
                possibities.clear();
                possibities.addAll(list);
            }
        }
        if (possibities.contains(0) || possibities.contains(360)) {
            out.println("YES");
        } else {
            out.println("NO");
        }

    }
}
