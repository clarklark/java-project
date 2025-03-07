package b4_commonClass.bignum;

import java.math.BigDecimal;

public class BigDecimal01 {
    public static void main(String[] args) {
        BigDecimal bigD1=new BigDecimal("0.1145141919810");
        BigDecimal bigD2=new BigDecimal("0.2014243716");
        System.out.println(bigD1.add(bigD2));
        System.out.println(bigD1.subtract(bigD2));
        System.out.println(bigD1.multiply(bigD2));
        //System.out.println(bigD1.divide(bigD2));//除不尽会报错

        System.out.println(bigD1.divide(bigD2, BigDecimal.ROUND_CEILING));//划定精度
    }
}
