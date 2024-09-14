package commonClass.math;

public class MathMethod01 {
    public static void main(String[] args) {
        // abs(int a) 返回 a 的绝对值
        int absValue = Math.abs(-10);
        System.out.println("绝对值: " + absValue); // 输出 10

        // max(int a, int b) 返回 a 和 b 中的最大值
        int maxValue = Math.max(5, 10);
        System.out.println("最大值: " + maxValue); // 输出 10

        // min(int a, int b) 返回 a 和 b 中的最小值
        int minValue = Math.min(5, 10);
        System.out.println("最小值: " + minValue); // 输出 5

        // pow(double a, double b) 返回 a 的 b 次幂的值
        double powerValue = Math.pow(2, 3);
        System.out.println("幂运算: " + powerValue); // 输出 8.0

        // sqrt(double a) 返回 a 的平方根
        double sqrtValue = Math.sqrt(16);
        System.out.println("平方根: " + sqrtValue); // 输出 4.0

        // round(double a) 返回最接近 a 的 long（double 版本返回 long，float 版本返回 int）
        long roundValue = Math.round(3.6);
        System.out.println("四舍五入: " + roundValue); // 输出 4

        // ceil(double a) 返回大于等于 a 的最小整数值，类型为 double
        double ceilValue = Math.ceil(3.2);
        System.out.println("向上取整: " + ceilValue); // 输出 4.0

        // floor(double a) 返回小于等于 a 的最大整数值，类型为 double
        double floorValue = Math.floor(3.8);
        System.out.println("向下取整: " + floorValue); // 输出 3.0

        // random() 返回带正号的 double 值，大于等于 0.0 且小于 1.0
        int randomValue =(int)(1+ Math.random()*(8));//生成从1开始8个int
        System.out.println("随机数: " + randomValue); // 输出 0.0 到 1.0 之间的一个随机数

        // exp(double a) 返回 e^a
        double expValue = Math.exp(1);
        System.out.println("e 的 1 次幂: " + expValue); // 输出 e (自然对数的底数)

        // log(double a) 返回 ln a
        double logValue = Math.log(Math.E);
        System.out.println("e 的自然对数: " + logValue); // 输出 1.0

        // sin(double a) 返回 a 的正弦值
        double sinValue = Math.sin(Math.PI / 2);
        System.out.println("π/2 的正弦值: " + sinValue); // 输出 1.0

        // cos(double a) 返回 a 的余弦值
        double cosValue = Math.cos(Math.PI);
        System.out.println("π 的余弦值: " + cosValue); // 输出 -1.0

        // tan(double a) 返回 a 的正切值
        double tanValue = Math.tan(Math.PI / 4);
        System.out.println("π/4 的正切值: " + tanValue); // 输出 1.0
    }
}
