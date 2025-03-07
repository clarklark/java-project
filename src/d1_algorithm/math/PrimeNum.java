package d1_algorithm.math;

public class PrimeNum {
    public static void main(String[] args) {
        System.out.println(findPrime(10000));
    }

    // 埃氏筛法找第 n 个素数
    public static int findPrime(int n) {
        if (n <= 0) {
            System.out.println("请输入正确索引");
            return -1;
        }
        // 根据经验公式估算数组大小
        int size = (int) (n * Math.log(n) * 2)+4;
        boolean[] isPrime = new boolean[size];
        for (int i = 2; i < size; i++) {
            isPrime[i] = true; // 默认所有数都是素数
        }

        int x = 2;
        while (x * x < size) {
            if (isPrime[x]) {
                int k = 2;
                while (k * x < size) {
                    isPrime[k++ * x] = false; // 标记非素数
                }
            }
            x++;
        }

        int count = 0;
        for (int i = 2; i < size; i++) {
            if (isPrime[i]) {
                count++;
                if (count == n) {
                    return i; // 返回第 n 个素数
                }
            }
        }
        return -1; // 如果没有找到第 n 个素数，返回 -1
    }
}