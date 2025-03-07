package b6_generics;

public class Extend {
    public static void main(String[] args) {
       // T1<Grandpa>t = new T1<>();
        T1<Son>t = new T1<>();
    }
}
class Grandpa{}
class Father extends Grandpa implements FuckMom{}
class Son extends Father{}
interface FuckMom{}
class T1<E extends Father>{}