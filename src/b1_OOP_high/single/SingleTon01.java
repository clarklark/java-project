package b1_OOP_high.single;

//单例模式-饿汉式(早早创建好老婆,十分饥饿)
//创建唯一的GirlFriend对象
//1.构造器私有化
//2.类的内部直接创建
//3.提供一个公共的static方法,返回gf
public class SingleTon01 {
    public static void main(String[] args) {
    GirlFriend instance01=GirlFriend.getInstance();
    GirlFriend instance02=GirlFriend.getInstance();
        System.out.println(instance01);
        System.out.println(instance02);
        System.out.println(instance01==instance02);//T
    }
}
//只能有一个GirlFriend
class GirlFriend{
    private String name;

    //为了能在静态方法中返回gf对象,用static修饰
    //对象通常是重量级对象,饿汉式可能造成创建了对象但是没有使用,造成资源浪费
    private static GirlFriend gf=new GirlFriend("朝武芳乃");
    private GirlFriend(String name){
        this.name=name;
    }
    public static  GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}