package d1_algorithm.math;

public class MaxCommon {
    public static void main(String[] args) {
        System.out.println(reMaxCommonFactor(81, 54));
        System.out.println(maxCommonFactor(81, 54));
    }

    //辗转相除法(欧几里得算法)
    public static int reMaxCommonFactor(int m, int n) {
        return m % n == 0 ? n : reMaxCommonFactor(n, m % n);
    }

    public static int maxCommonFactor(int m, int n) {
        int k = 1;
        while (m % n != 0) {
            k = m % n;
            m = n;
            n = k;
        }
        return k;
    }

    /*裴蜀公式
       a与b的最大公约数为d
    * ax+by=m有整数解<=>m是d整数倍
    * ax+by=1有整数解<=>a与b互素
     */



}

