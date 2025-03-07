package d1_algorithm.dynamicPrograming.bag;

public class zero_oneKnapsack {
    private static class Item {
        int index;
        String name;
        int value;
        int weight;

        public Item(int index, String name, int value, int weight) {
            this.index = index;
            this.name = name;
            this.value = value;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Item[] items = {new Item(0, "红宝石", 1200, 4),
                new Item(1, "绿宝石", 2400, 6),
                new Item(2, "白银", 300, 5),
                new Item(3, "钻石", 10000, 1)
        };
        System.out.println(select(items, 10));
        System.out.println(select1(items, 10));
    }

    public static int select(Item[] items, int total) {
        int[][] dp = new int[items.length][total];
        for (int i = 0; i < total; i++) {
            if (i >= items[0].weight) {
                dp[0][i] = items[0].value;
            }
        }
        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j < total; j++) {
                if (j >= items[i].weight) {
                    dp[i][j] = Integer.max(dp[i - 1][j], items[i].value + dp[i - 1][j - items[i].weight]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[items.length - 1][total - 1];
    }

    //降维
    public static int select1(Item[] items, int total) {
        int[] dp = new int[total];
        for (int i = 0; i < total; i++) {
            if (i >= items[0].weight) {
                dp[i] = items[0].value;
            }
        }
        for (int i = 1; i < items.length; i++) {
            for (int j = total - 1; j >= 0; j--) {
                if (j >= items[i].weight) {
                    dp[j] = Integer.max(dp[j], items[i].value + dp[j - items[i].weight]);
                }
            }
        }
        return dp[total - 1];

    }
}
