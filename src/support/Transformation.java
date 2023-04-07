package support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transformation {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToDoubleIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0][0];
        }
        String[] upperArray = input.split("]");

        List<List<Integer>> output = new ArrayList<>();
        for(String arrayString : upperArray){
            String[] parts = arrayString.substring(1, arrayString.length() ).split(",");

            List<Integer> list = new ArrayList<>();
            for (int index = 0; index < parts.length; index++) {
                String part = parts[index].trim().replaceAll(",", "").replaceAll("\\[", "");
                list.add(Integer.parseInt(part));
            }
            output.add(list);
        }
        int l = upperArray.length;
        int h = output.get(0).size();
        int[][] transfor = new int [l][h];
        int ii = 0;
        int jj = 0;
        for(List<Integer> xx : output) {
            jj =  0;
            for (Integer y : xx) {
                transfor[ii][jj++] = y;
            }
            ii++;
        };
        return transfor;
    }

    public static String[] stringToStringArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new String[0];
        }

        String[] parts = input.split(",");
        String[] output = new String[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim().replaceAll("\"", "");
            output[index] = part;
        }
        return output;
    }
}
