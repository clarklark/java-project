package commonClass.wrapper;

public class Wrapper {
    public static void main(String[] args) {
//        1. byte - Byte
//        2. short - Short
//        3. int - Integer
//        4. long - Long
//        5. float - Float
//        6. double - Double
//        7. char - Character
//        8. boolean - Boolean


        //手动装箱
        int n = 10;
        Integer integer = Integer.valueOf(n);
        //手动拆箱
        int i = integer.intValue();
        //自动装箱
        int n2=20;
        Integer integer2=n2;
        // 自动拆箱
        int n3=integer2;
    }
}
