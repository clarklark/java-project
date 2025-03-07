package b1_OOP_high.InnerClass;

public class AnonymousInner {
    public static void main(String[] args) {
        Other02 other02 = new Other02();
        other02.method();
    }
}

interface IA {
    public void cry();
}

class Other02 {
    public void method() {
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫");
            }
        };
        tiger.cry();
        //匿名内部类
        //1.编译类型Father
        //2.运行类型Other02$2
        //3.底层会创建匿名内部类
        Father father = new Father("clark") {
            public void test(){
                System.out.println("匿名内部类test()");
            }
        };
        System.out.println(father.getClass());
        father.test();
    }
}

class Father {
    private String name;

    public Father(String name) {
    }

    void test() {

    }
}
