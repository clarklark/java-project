package collection_.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
@SuppressWarnings("all")
public class SetMethod {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add("bill");
        set.add("bill");
        set.add("clark");
        set.add("frank");
        set.add(null);
        //无序,不能存放重复数据
        System.out.println("collections.set="+set);

        Iterator iterator=set.iterator();
        for(Object o:set){
            System.out.println("o="+o);
        }
    }
}
