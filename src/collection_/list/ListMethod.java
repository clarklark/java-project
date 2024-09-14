package collection_.list;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class ListMethod {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("clark");
        list.add("jerry");
        list.add("rick");
        //1.插入制定索引
        list.add(1,"dear");


        List list2=new ArrayList();
        list2.add("tom");
        list2.add("tim");
        //2.
        list.addAll(list2);
        list.addAll(0,list2);

        System.out.println("collections.list="+list);

        //3.
        System.out.println(list.lastIndexOf("clark"));

        //4.
        list.set(0,"mirie");

        System.out.println("collections.list="+list);
    }
}
