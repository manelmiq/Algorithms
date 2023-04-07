package leetcode.medium;

import support.Transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class NearestColor {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int[] arr = Transformation.stringToIntegerArray(input);
        String input2 = in.next();
        int[][] arr2 = Transformation.stringToDoubleIntegerArray(input2);
        out.println(shortestDistanceColor(arr, arr2));
    }

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, List<Integer>> colorIndex = new HashMap<>();
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < colors.length; i++) {
            List<Integer> list = colorIndex.getOrDefault(colors[i], new ArrayList<>());
            list.add(i);
            colorIndex.put(colors[i], list);
        }
        for (int[] q : queries) {
            answers.add(nearest(q, colorIndex));
        }
        return answers;
    }

    public int nearest(int[] q, HashMap<Integer, List<Integer>> m) {
        int colorSet = q[1];
        int indexNear = q[0];
        if (m.get(colorSet) == null) {
            return -1;
        }
        int low = 0;
        int high = m.get(colorSet).size();
        int middle = (low + high) / 2;
//        Integer.MA
        // System.out.println("finding" + indexNear);
        // System.out.println("middle" + middle);
        // System.out.println(m.get(colorSet));

        if (m.get(colorSet).get(0) >= indexNear) {
            return m.get(colorSet).get(0) - indexNear;
        }

        if (m.get(colorSet).get(m.get(colorSet).size() - 1) <= indexNear) {
            return indexNear - m.get(colorSet).get(m.get(colorSet).size() - 1);
        }

        while (low <= high) {
            if (middle < 0 || middle >= m.get(colorSet).size()) {
                break;
            }
            if (m.get(colorSet).get(middle) == indexNear) {
                return 0;
            } else if (m.get(colorSet).get(middle) < indexNear) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            middle = (low + high) / 2;
        }
        // System.out.println("Middle" + middle);
        return middle - indexNear;
    }
}
