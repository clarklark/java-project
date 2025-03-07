package b1_OOP_high.CodeBlock;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println();
        B b = new B();
    }

}

class A extends B {
    static {
        System.out.println("A的静态代码块");//先执行
    }

    static {
        System.out.println("A的普通代码块");//先执行
    }

    private static int n1 = getN1();
    private int n2 = getN2();

    public static int getN1() {
        System.out.println("getN1被调用");//后执行
        return 100;
    }

    public int getN2() {
        System.out.println("getN2被调用");
        return 200;
    }

    public A() {
        System.out.println("A()被调用");
    }
}

class B {
    static {
        System.out.println("B的静态代码块");//先执行
    }

    static {
        System.out.println("B的普通代码块");//先执行
    }

    private static int n3 = getN3();
    private int n4 = getN4();

    public static int getN3() {
        System.out.println("getN3被调用");//后执行
        return 300;
    }

    public int getN4() {
        System.out.println("getN4被调用");
        return 400;
    }

    public B() {
        System.out.println("B()被调用");
    }
}