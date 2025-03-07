package b6_generics;

public class CustomGenericsMethod {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("byd",100);
        car.run("bm",1.1,'1');
    }
}
class Car<A,B>{
    A a;
    B b;
    public <E,R>void fly(E e,R r){
        System.out.println(e.getClass());
        System.out.println(r.getClass());

    }
    public <K>void run(A a,B b,K k){
        System.out.println(a.getClass());
        System.out.println(b.getClass());
        System.out.println(k.getClass());

    }
}