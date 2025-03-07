package d2_datastructures.string;

/**
 * 最长回文子串问题,中心扩展算法
 */
public class CenterExtend {
    public static void main(String[] args) {
        String str = "bccbcbabcbafa";
        System.out.println(lps(str));
    }

    public static String lps(String str) {
        left = 0;
        right = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            extend(chars, i, i);
            extend(chars, i, i + 1);
        }
        return new String(chars, left, right - left + 1);
    }

    static int left;
    static int right;

    public static void extend(char[] chars, int i, int j) {
        while (i >= 0 && j < chars.length
                && chars[i] == chars[j]) {
            i--;
            j++;
        }
        if (j - i > right - left) {
            left = i;
            right = j;
        }
    }

}
