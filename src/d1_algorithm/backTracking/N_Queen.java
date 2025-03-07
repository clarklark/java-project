package d1_algorithm.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queen {
    public static void main(String[] args) {
        int n = 7;
        List<List<String>> solves = new N_Queen().solveNQueens(n);
        System.out.println(n+"皇后问题共有"+solves.size()+"种解法");
        if(solves.size()>10){
            System.out.println("解法太多,不一一展示");
            System.exit(-1);
        }
        int i = 1;
        for (List<String> solve : solves) {
            System.out.println("解法" + i++);
            for (String line : solve) {
                System.out.println(line);
            }
        }
    }

    /**
     * N皇后问题,在N*N的棋盘中放置N个皇后
     * 要求:每个皇后所在的行列以及斜线上不得有别的皇后
     * 求有多少种放置方法
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] col = new boolean[n];//列冲突

        boolean[] lb = new boolean[2 * n - 1];//左斜线冲突

        boolean[] rb = new boolean[2 * n - 1];//右斜线冲突

        char[][] table = new char[n][n];
        for (char[] t : table) {
            Arrays.fill(t, '.');
        }
        dfs(0, n, table, col, lb, rb, result);

        return result;
    }

    public static void dfs(int i, int n, char[][] table, boolean[] col, boolean[] lb, boolean[] rb, List<List<String>> result) {
        if (i == n) {//遍历结束
            List<String> list = new ArrayList<>();
            for (char[] t : table) {
                list.add(new String(t));
            }
            result.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (col[j] || lb[i + j] || rb[n - 1 - (i - j)]) {
                continue;
            }
            /*
                左斜线
              j 0 1 2 3  = i + j
            i * * * * *
            0 * 0 1 2 3
            1 * 1 2 3 4
            2 * 2 3 4 5
            3 * 3 4 5 6

             右斜线
              j 0 1 2 3 = (4-1)-(i-j)
            i * * * * *
            0 * 3 2 1 0
            1 * 4 3 2 1
            2 * 5 4 3 2
            3 * 6 5 4 3

             */
            table[i][j] = 'Q';
            col[j] = true;
            lb[i + j] = true;
            rb[n - 1 - (i - j)] = true;
            dfs(i + 1, n, table, col, lb, rb, result);
            table[i][j] = '.';
            col[j] = false;
            lb[i + j] = false;
            rb[n - 1 - (i - j)] = false;
        }
    }
}
