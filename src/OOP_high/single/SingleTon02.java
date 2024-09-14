package OOP_high.single;

//单例模式-懒汉式
//1.构造器私有化
//2.定义一个static静态属性对象
//3.提供public的static方法,可以返回一个Wife对象
//4.懒汉式,只有当用户使用getInstance时,创建wife对象,再次调用时,返回上次创建的wife对象
//从而实现了单例
public class SingleTon02 {
    public static void main(String[] args) {
    Wife instance=Wife.getInstance();
        System.out.println(instance);
    }
}
class Wife{
    private String name;
    private static Wife wife;
    private Wife(String name){
        this.name=name;
    }

    public static Wife getInstance(){
        if(wife==null){
            wife=new Wife("乃芳");
        }
        return wife;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                '}';
    }
}