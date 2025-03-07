package b1_OOP_high.final_;

public class Final01 {
    public static final int TAX=10;
    public static void main(String[] args) {
        C c=new C();

    }
}
final class A{}
//class B extends A{} //错误
class C{
    private final int AM=0;
    public final void say(){
        System.out.println("C say");
    }
}
class D extends C{
}