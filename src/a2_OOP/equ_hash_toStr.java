package a2_OOP;

/**
 * equals,hashCode,toString
 */
public class equ_hash_toStr {
    public static void main(String[] args) {
        A a=new A();
        A b=new A();
        A c=a;
        System.out.println("a.hashCode="+a.hashCode()+" a.toString="+a.toString());
        //后者是前者16进制
        System.out.println("b.hashCode="+b.hashCode());
        System.out.println("c.hashCode="+c.hashCode());//hashCode通过地址转化而来
        String str1=new String("jdk");
        String str2=new String("jdk");
        System.out.println(str1==str2);//false
        System.out.println(str1.equals(str2));//true
    }
}
class A{}