package d1_algorithm.dynamicPrograming.linearDP;


//最长公共子串问题
public class LCSubString {
    public static void main(String[] args) {
        System.out.println(LC("theory", "atheist"));
    }

    public static int LC(String a, String b) {
        int max = 0;
        int[] dp = new int[a.length() + 1];
        dp[0] = 0;
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == b.charAt(i)) {
                    dp[j + 1] = dp[j] + 1;
                }
                max = Integer.max(max, dp[j + 1]);
            }
        }
        return max;
    }
}
