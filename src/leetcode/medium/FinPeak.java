package leetcode.medium;

import support.Transformation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;

public class FinPeak {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String input = in.next();
        int[][] m = Transformation.stringToDoubleIntegerArray(input);
        out.println(Arrays.toString(findPeakGrid(m)));
    }
    class Position implements Comparable<Position> {
        int x;
        int y;
        int value;
        Position(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
        String printMe(){
            return "x :" +  x + "y:" + y;
        }

        public int compareTo(Position p2) {
            return p2.value - this.value;
        }
    }
    // 1, 1 -> 1, 2 -> 1, 0, 0, 1, 2, 0

    int[] xPlus = {1, -1, 0, 0};
    int[] yPlus = {0, 0, 1, -1};

    public int[] findPeakGrid(int[][] mat) {
        PriorityQueue<Position> q = new PriorityQueue<>();

        q.add(new Position(mat.length/2, mat[0].length/2, mat[mat.length/2][mat[0].length/2]));
        while(!q.isEmpty()){
            Position curr = q.poll();
            System.out.println("value ->" +mat[curr.x][curr.y] + "=" +  curr.printMe());
            if(isPeak(curr.x, curr.y, mat)){
                int[] ans = new int[2];
                ans[0] = curr.x ;
                ans[1] = curr.y ;
                return ans;
            }
            for(int i = 0; i < 4; i++){
                int nextX = curr.x + xPlus[i];
                int nextY = curr.y + yPlus[i];
                if((nextX < 0 || nextX >= mat.length) ||
                        (nextY < 0) || nextY >= (mat[0].length))  {
                    continue;
                }
                if(mat[nextX][nextY] > mat[curr.x][curr.y]){
                    q.add(new Position(nextX, nextY, mat[nextX][nextY]));
                }
            }
        }
        return null;

    }



    boolean isPeak(int x, int y, int[][] m ){
        for(int i = 0; i < 4; i++){
            int nextX = x + xPlus[i];
            int nextY = y + yPlus[i];
            if((nextX < 0 || nextX >= m.length) ||
                    (nextY < 0) || nextY >= (m[0].length))  {
                continue;
            }
            // System.out.println("nextX" + nextX + "nextY" + nextY);
            if(m[nextX][nextY] > m[x][y]){
                return false;
            }
        }
        return true;
    }
}
