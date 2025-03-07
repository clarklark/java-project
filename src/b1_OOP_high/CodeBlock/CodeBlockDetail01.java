package b1_OOP_high.CodeBlock;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        AA aa = new AA();//BB AA(单独执行时结果)
        System.out.println();
        BB bb = new BB();//BB(单独执行时结果)
        System.out.println();
        BB ba = new AA();//BB AA(单独执行时结果)
        //静态代码块只执行一次,普通代码块每次都执行
    }
}


class AA extends BB {
    static {
        System.out.println("AA的静态代码块被执行");
    }
    {
        System.out.println("AA的普通代码块被执行");
    }
}

class BB {
    static {
        System.out.println("BB的静态代码块被执行");
    }
    {
        System.out.println("BB的普通代码块被执行");
    }
}