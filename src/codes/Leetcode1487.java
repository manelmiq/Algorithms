package codes;

import java.util.*;
import java.io.PrintWriter;

import static support.Transformation.stringToStringArray;

public class Leetcode1487 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        String[] inputs = stringToStringArray(s);
        out.println(Arrays.toString(getFolderNames(inputs)));
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> assignes = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            String key = names[i];
            int appCount = (assignes.get(key) == null) ? 0 : assignes.get(key);
            if (appCount == 0) {
                assignes.put(key, ++appCount);
            } else {
                int k = assignes.get(key);
                StringBuilder str = new StringBuilder();
                str.append(key);
                str.append('(');
                str.append(k);
                str.append(')');
                while (assignes.get(str.toString()) != null) {
                    StringBuilder strTemp = new StringBuilder();
                    strTemp.append(key);
                    strTemp.append('(');
                    strTemp.append(++k);
                    strTemp.append(')');
                    str = strTemp;
                }
                names[i] = str.toString();
                assignes.put(str.toString(), 1);
                assignes.put(key, k);
            }

        }
        return names;
    }
}
