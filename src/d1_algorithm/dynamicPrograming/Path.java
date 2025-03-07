package d1_algorithm.dynamicPrograming;


//m*n的矩形,机器人从左上角走到右下角的总走法,只能向下,向右走
public class Path {
    public static void main(String[] args) {
        System.out.println(uniquePaths(5, 4));
        System.out.println(uniquePath(5, 4));
    }

    //思路,走到第一行和第一列的走法都是1,走到其他的所有格子的走法,都是走到它左侧和上侧的走法数量之和
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    //实际上,上侧值可以由当前位置的值平替,所以不需要开辟二维数组
    public static int uniquePath(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
