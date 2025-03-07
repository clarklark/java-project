package b4_commonClass.bignum;

import java.math.BigInteger;

public class BigInteger01 {
    public static void main(String[] args) {
        BigInteger big1=new BigInteger("1145141918810");
        BigInteger big2=new BigInteger("201437202416");
        BigInteger add=big1.add(big2);
        BigInteger sub=big1.subtract(big2);
        BigInteger mul=big1.multiply(big2);
        BigInteger div=big1.divide(big2);
        System.out.println(add);
        System.out.println(sub);
        System.out.println(mul);
        System.out.println(div);
    }
}
