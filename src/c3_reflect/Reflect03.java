package c3_reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class Reflect03 {

    /*
        在一个Integer泛型的集合中,插入一个String类型的字符串
        java中的泛型是假的,只在编译时起效
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,4,4,5,6);

        Class<? extends ArrayList> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,"abc");

        System.out.println(list);


    }
}
