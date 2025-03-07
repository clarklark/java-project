package d1_algorithm.dynamicPrograming.linearDP;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(7));
        System.out.println(fibonacci1(7));
    }

    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
