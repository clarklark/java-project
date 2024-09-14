package algorithm;

public class DP {
    public static void main(String[] args) {
        int []value={6,3,5,4,6,7};
        int []weight={2,5,4,2,3,5};
        int maxWeight=10;
        System.out.println(knapsack(weight,value,maxWeight));
    }
    public  static int knapsack(int[] weights, int[] values, int maxWeight) {
        int n = weights.length;
        int[][] dp = new int[n + 1][maxWeight + 1];

        // 初始化动态规划数组
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (weights[i - 1] <= w) {
                    // 选择当前物品或不选择当前物品，取两种情况的较大值
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    // 当前物品重量超过背包容量，不选择当前物品
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][maxWeight];
    }
}

