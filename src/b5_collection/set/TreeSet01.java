package b5_collection.set;

import java.util.Comparator;
import java.util.TreeSet;
@SuppressWarnings("all")
public class TreeSet01 {
    public static void main(String[] args) {
        //1.使用无参构造器时是无序的
        //2.重写排序方法
        TreeSet treeSet=new TreeSet(new Comparator(){
            @Override
            public int compare(Object o1,Object o2){
                return ((String)o1).compareTo((String)o2);

            }
        });



        treeSet.add("jack");
        treeSet.add("jerry");
        treeSet.add("rick");
        System.out.println(treeSet);
    }
}
