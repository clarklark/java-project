package d2_datastructures.string;

public class stringMatching {
    public static void main(String[] args) {
        String text = "ABACABACABABACBA";
        String keyword = "ABACABAB";
        System.out.println(KMPSearch(text, keyword));
    }

    //KMP
    public static int KMPSearch(String text, String keyword) {
        char[] origin = text.toCharArray();
        char[] pattern = keyword.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = buildNext(keyword);
        while (pattern.length - j <= origin.length - i) {
            if (origin[i] == pattern[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
            if (j == pattern.length) {
                return i - j;
            }
        }
        return -1;
    }

    public static int[] buildNext(String keyword) {
        int i = 1;
        int len = 0;
        int[] next = new int[keyword.length()];
        next[0] = 0;
        while (i < next.length) {
            if (keyword.charAt(i) == keyword.charAt(len)) {
                len++;
                next[i] = len;
                i++;
            } else {
                if (len == 0) {
                    next[len] = 0;
                    i++;
                } else {
                    len = next[len - 1];
                }
            }
        }
        return next;
    }
}
