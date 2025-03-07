package b5_collection.list;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("all")
public class List01 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add("clark");
        list.add("jerry");
        list.add("tom");
        list.add("rick");
        list.remove(1);
        list.set(1,"jick");
        System.out.println(list.indexOf("clark"));
        System.out.println(list);

    }
}
