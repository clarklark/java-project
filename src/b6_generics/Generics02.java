package b6_generics;

import java.util.ArrayList;
import java.util.List;

public class Generics02 {
    public static void main(String[] args) {
        //注意:E的具体数据类型在定义person对象的时候指定,即在编译期间,就确定E的类型
        Person<String>person1=new Person<String>("clark");
        /*
        等于
        class Person{
            String s;
            public Person(String s){
                this.s=s;
            }
            public String getS(){
                return s;
            }
        }
         */
        //细节,可以传子类
        List<Object> list=new ArrayList<>(12);
        //不写默认为Object类
        List list1=new ArrayList<>();
        //后可以不加
    }
}
class Person<E>{
    E s;
    public Person(E s){
        this.s=s;
    }
    public E getS(){
        return s;
    }
}
