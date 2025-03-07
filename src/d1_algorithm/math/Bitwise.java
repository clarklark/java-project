package d1_algorithm.math;

public class Bitwise {
    public static void main(String[] args) {
        /*
        基本应用
        a^a = 0
        a^0 = a

        a>>1 = a/2
        a<<1 = a*2

        如果a^b=x则有 a^x=b
         */




        //1.求N的二进制数的1的个数

        //引理,x&(x-1)消去x最末位的1
        //例子:10-1010   1010 & 1001 =1000
        int n = 7;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(count);


    }

}
