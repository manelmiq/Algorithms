package codes;

import java.util.*;
import java.io.PrintWriter;

public class DominoPieace {
    class Domino {
        int a, b;

        public Domino(int i, int i1) {
            a = i;
            b = i1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Domino domino = (Domino) o;
            return a == domino.a &&
                    b == domino.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "D[" + a +
                    ", " + b +
                    ']';
        }
    }

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


    public static int[][] stringToInt2dArray(String s) {
        String[][] arr = Arrays.stream(s.substring(2, s.length() - 2)
                .split("\\],\\["))
                .map(e -> Arrays.stream(e.split("\\s*,\\s*"))
                        .toArray(String[]::new)).toArray(String[][]::new);
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[i][j] = Integer.parseInt(arr[i][j]);
            }
        }
        return result;
    }


    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int[][] converted = stringToInt2dArray(input);
        out.println(numEquivDominoPairs(converted));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        HashMap<Domino, LinkedList<Integer>> hash = new HashMap<>();
        HashMap<Domino, Integer> solution = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            Domino d1 = new Domino(dominoes[i][0], dominoes[i][1]);
            if (hash.get(d1) == null) {
                LinkedList<Integer> list = hash.get(d1);
                list = new LinkedList<>();
                hash.put(d1, list);
            }
            hash.get(d1).add(i);
        }
        for (int i = 0; i < dominoes.length; i++) {
            Domino d1 = new Domino(dominoes[i][0], dominoes[i][1]);
            Domino d2 = new Domino(dominoes[i][1], dominoes[i][0]);
            hash.get(d1).removeFirst();
            if (hash.get(d1) != null ) {
//                System.out.println("search itselft");
                ans += hash.get(d1).size();
            }

            if(d1.a != d2.a){
                if (hash.get(d2) != null){
//                    System.out.println("search oppositive");
                    ans += hash.get(d2).size();
                }
            }

            System.out.println("ans " + ans);

        }
        int debug = 1;

        return ans;
    }


}
