package d1_algorithm.math;

public class ExtendedEuclidAlgorithm {
    public static void main(String[] args) {
        int a = 21;
        int b =8;
        int m = 1; // ax + by = m

        int[] solution = findSolution(a, b, m);

        if (solution[0] == -1 && solution[1] == -1) {
            System.out.println("该方程" + a + "x + " + b + "y = " + m+"无整数解");
        } else {
            System.out.println("该方程:" + a + "x + " + b + "y = " + m + "的解是");
            System.out.println("x = " + solution[0]);
            System.out.println("y = " + solution[1]);
        }
    }

    // 扩展欧几里得算法
    public static int[] extendedEuclid(int a, int b) {
        if (b == 0) {
            return new int[]{1, 0, a}; // ax + by = a
        } else {
            int[] result = extendedEuclid(b, a % b);
            int x = result[1];
            int y = result[0] - (a / b) * result[1];
            return new int[]{x, y, result[2]};
        }
    }

    // 检查是否有整数解并找到它
    public static int[] findSolution(int a, int b, int m) {
        int[] result = extendedEuclid(a, b);
        int x = result[0];
        int y = result[1];
        int gcd = result[2];

        // 如果m不是gcd的倍数，则没有整数解
        if (m % gcd != 0) {
            return new int[]{-1, -1}; // 表示无解
        }

        // 找到特解
        int x0 = x * (m / gcd);
        int y0 = y * (m / gcd);

        // 返回特解
        return new int[]{x0, y0};
    }


}
