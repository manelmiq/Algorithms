package codes;

import java.util.*;
import java.io.PrintWriter;


public class nQueens {
    int num = 0;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        this.num = in.nextInt();
        out.println( printCorrect(solveNQueens(num) ));
    }

    private List<List<String>> printCorrect(List<String[]> solveNQueens) {
        List<List<String>> list = new LinkedList<>();
        for(int i = 0; i < solveNQueens.size(); i++){
            list.add(Arrays.asList(solveNQueens.get(i)));
        }
        return list;
    }


    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();

        if (n == 0 || n == 2 || n == 3) {
            return result;
        }

        solveNqueensHelper( 0, new int[n], result);

        return result;
    }

    private void solveNqueensHelper( int row, int[] board, List<String[]> solutions) {
        if (row ==  num) {
            String[] solution = new String[num];
            for (int i = 0; i < num; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    temp.append((board[i] == j) ? 'Q' : '.');
                }
                solution[i] = temp.toString();
            }
            solutions.add(solution);
            return;
        }

        for (int j = 0; j < num; j++) {
            if (isValid(j, row, board) == true) {
                board[row] = j;
                solveNqueensHelper( row + 1, board, solutions);
            }
        }
    }

    private boolean isValid(int col, int row, int[] board) {
        for (int i = 0; i < row; i++) {
            if (col == board[i] || row - i == Math.abs(col - board[i])) {
                return false;
            }
        }
        return true;
    }


}

//[
//[Q...., ...Q., .Q..., ....Q, ..Q..],
//[..Q.., Q...., ...Q., .Q..., ....Q],
//[.Q..., ...Q., Q...., ..Q.., ....Q],
//[.Q..., ....Q, ..Q.., Q...., ...Q.],
//[...Q., .Q..., ....Q, ..Q.., Q....]]
//
//
//
//[
//["Q....","..Q..","....Q",".Q...","...Q."],["Q....","...Q.",".Q...","....Q","..Q.."],
//[".Q...","...Q.","Q....","..Q..","....Q"],[".Q...","....Q","..Q..","Q....","...Q."],
//["..Q..","Q....","...Q.",".Q...","....Q"],["..Q..","....Q",".Q...","...Q.","Q...."],
//["...Q.","Q....","..Q..","....Q",".Q..."],["...Q.",".Q...","....Q","..Q..","Q...."],
//["....Q",".Q...","...Q.","Q....","..Q.."],["....Q","..Q..","Q....","...Q.",".Q..."]]