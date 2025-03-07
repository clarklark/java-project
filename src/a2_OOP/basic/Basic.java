package a2_OOP.basic;

public class Basic {
    public static void main(String[] args) {
        //1.异或运算(是否不一样)   同0异1
        //x^x=0,x^0=x
        int a = 3, b = 4;
        a = a ^ b;
        b = a ^ b;//b=(a^b)^b=a^0=a;
        a = b ^ a;//a=(a^b)^a=b
        System.out.println(a + " " + b);

        //2.三元运算符是一个整体


        //3.int的闹鬼
        int sum = 0, i = 1;
        while (sum != 10) {
            sum += i * 3 + 3;
        }
        System.out.println(sum);
        //short范围-65537到65535 short a=65535,则a++=-65537
        //int 同理

        //4.八种数据类型对应的各自装箱类和范围
//        1. byte：-2 ^ 7 ~2 ^ 7 - 1，即 - 128 ~127。1 字节。Byte。末尾加B
//        2. short：-2 ^ 15 ~2 ^ 15 - 1，即 - 32768 ~32767。2 字节。Short。末尾加S
//        3. 有符号int：-2 ^ 31 ~2 ^ 31 - 1，即 - 2147483648 ~2147483647。4 字节。Integer。
//        无符号int：0 ~2 ^ 32 - 1
//        4. long：-2 ^ 63 ~2 ^ 63 - 1，即 - 9223372036854774808 ~9223372036854774807。8 字节Long末尾加L（也可以不加L）
//        浮点型：
//        5.f loat：4 字节 Float 末尾加F(也可以不加F)
//        6.d ouble：8 字节。Double。
//        字符型：
//        7. char：2 字节。Character。
//        布尔型：
//        8. boolean：Boolean。
    }
}
