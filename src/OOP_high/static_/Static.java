package OOP_high.static_;

public class Static {
    public static void main(String[] args) {
        //静态方法和变量不需要实例化
        say();
        new A().say();
        System.out.println(a);
        System.out.println(A.a);
    }
    public static int a=4;
    public static void say(){
        System.out.println("yeah");
    }
}
class A{
    public static int a=44;
    public int b;
    public void say(){
        System.out.println("no");
    }
    public static int getA(){
        //return b; //静态方法只能调用静态变量
        return a;
    }

}