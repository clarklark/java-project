package OOP.polymorphism.ploy;

public class ployDetails {
    public static void main(String []args){
        Dad dad=new Son();//向上转型
        System.out.println(dad.count);//20 看编译类型
        Son son=new Son();
        //instanceOf用于判断某个变量是否为某个类的类型或者其子类型
        System.out.println(son instanceof Dad);//判断son的运行类型是不是Dad
    }
}
class Dad{
    int count=20;
}
class Son extends Dad{
    int count =10;
}