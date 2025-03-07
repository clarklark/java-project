package b1_OOP_high.abstract_;

public class Abstract01 {
    public static void main(String[] args) {
       // Animal a=new Animal()//抽象类不能实例化
    }
}

//抽象方法不能用final,static,private来修饰,因为它必须靠子类来继承
abstract class Animal{
    private String name;

    //abstract int id;// 错误 abstract只能修饰类和方法

    //抽象方法必须在抽象类里,抽象类不一定包含抽闲方法
    public abstract void eat();
}
//如果一个类继承了一个抽象类,它必须实现抽象类的所有方法,除非它自己也声明为抽象类
class Cat extends Animal{
    @Override
    public void eat() {

    }
}
abstract class Dog extends Animal{

}