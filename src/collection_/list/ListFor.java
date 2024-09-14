package collection_.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressWarnings("all")
public class ListFor {
    public static void main(String[] args) {
        //List collections.list=new LinkedList();
        //List collections.list=new Vector();
        List list=new ArrayList();
        list.add("clark");
        list.add("jerry");
        list.add("tom");
        list.add("rick");
        //1.迭代器
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            Object name=iterator.next();
            System.out.println("迭代器name="+name);
        }

        //2.增强for循环
        for(Object name:list){
            System.out.println("增强for循环name="+name);
        }

        //3.普通for循环
        for(int i=0;i<list.size();i++){
            System.out.println("普通for循环name="+list.get(i));
        }
    }
}
