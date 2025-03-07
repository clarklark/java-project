package d1_algorithm.greedy;

public class Coins {
    public static void main(String[] args) {
        int an = coinChange(new int[]{5, 2, 1}, 18);
        System.out.println(an);
    }

    //最少硬币数量凑出18,贪心思路,并不全能,如15 10 1,20
    public static int coinChange(int[] coins, int amount) {
        int reminder = amount;
        int count = 0;
        for (int coin : coins) {
            while (reminder > coin) {
                reminder -= coin;
                count++;
            }
            if (reminder == coin) {
                reminder = 0;
                count++;
                break;
            }
        }
        if (reminder == 0) {
            return count;
        } else {
            return -1;
        }
    }
}
