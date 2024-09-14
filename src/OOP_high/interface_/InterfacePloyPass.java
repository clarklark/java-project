package OOP_high.interface_;

public class InterfacePloyPass {
    public static void main(String[] args) {
        //接口类型的变量可以指向,实现了接口类的对象实例
        IH ih =new A();
        //如果IG继承了IH接口,而A实现了IG接口
        //实际就相当于A也实现了IH接口
        //这就是所谓 接口多态
        IG ig=new A();

    }
}
interface IH{
    public void say();
}
interface IG extends IH{

}
class A implements IG{
    //A必须实现IH的方法
    @Override
    public void say() {

    }
}