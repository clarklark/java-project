package b6_generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExtends {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        print1(list1);
        print1(list2);
        print1(list3);
        print1(list4);
        print1(list5);

//        print2(list1);
//        print2(list2);
        print2(list3);
        print2(list4);
        print2(list5);


        print3(list1);
//        print3(list2);
        print3(list3);
//        print3(list4);
//        print3(list5);
    }

    //任何类型的泛型都可以接受
    public static void print1(List<?> c) {
        for (Object o : c) {
            System.out.println(c);
        }
    }

    //表示上限,可以接受A和A的子类
    public static void print2(List<? extends AA> c) {
        for (Object o : c) {
            System.out.println(c);
        }
    }

    //表示下线,可以接受A和A的父类
    public static void print3(List<? super AA> c) {
        for (Object o : c) {
            System.out.println(c);
        }
    }

}

class AA {
}

class BB extends AA {
}

class CC extends AA {
}