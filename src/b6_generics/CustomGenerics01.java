package b6_generics;

public class CustomGenerics01 {
    public static void main(String[] args) {

    }
}
//使用泛型数组不能示例化
//静态方法不能用泛型
class Tiger<T,R,M> implements IUA{
    String name;
    T t;
    R r;
    M m;
    T []arr;
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    @Override
    public void run(String s, Double aDouble) {

    }
}
interface IA<T,R>{
    public void run(T t,R r);

}
interface IUA extends IA<String,Double>{

}