package b1_OOP_high.InnerClass;
//类的五大成员 属性 方法 构造器 代码块 内部类
//内部类最大特点是可以直接访问私有属性，比且可以体现类与类之间的包含关系
public class Local {
    public static  void main(String []args){
        Other01 other=new Other01();
        other.m1();
    }
}
class Other01{//外部类
    private int n1=100;
    private void m2(){
        System.out.println("m2()");
    }//私有方法
    public void m1(){//方法
        //局部内类变量是定义在外部类的局部变量，通常在方法
        //不能添加访问修饰符，但是可以加final
        //作用域:仅仅在定义它的方法或代码块
        class Inner{//局部内部类(本质仍然是一个类)
            //可以直接访问外部类的所有成员，包括私有的
            private int n1=800;
            public void f1(){
                //局部内部类可以直接访问外部类成员
                //如果外部类和局部内部类的成员重名时，默认就近原则，
                //如果想访问外部类成员，则可以使用(外部类名.this.成员)去访问
                m2();
                System.out.println("n1="+Inner.this.n1+" 外部类的n1="+Other01.this.n1);//800 100
            }
        }
        //外部类在方法中，可以直接创建Inner对象，然后调用方法
        Inner inner=new Inner();
        inner.f1();
    }

}
