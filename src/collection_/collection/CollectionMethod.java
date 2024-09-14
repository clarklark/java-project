package collection_.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        List list=new ArrayList();
        //1.add 添加单个元素
        list.add(12);//
        list.add("lkd");
        list.add(true);
        System.out.println("add后list="+list);
        //2.remove 删除单个元素
        list.remove(0);//索引
        list.remove(true);//指定元素
        System.out.println("remove后list="+list);
        //3.contains 是否包含 索引/指定元素
        System.out.println(list.contains("lkd"));
        System.out.println(list.contains(0));
        //4.size 大小
        System.out.println("collections.list.size()="+list.size());
        //5.isEmpty 是否为空
        System.out.println("是否为空"+list.isEmpty());
        //6.clear 清除所有元素
        list.clear();
        System.out.println("clear()后"+list);
        //7.addAll
        List list2=new ArrayList();
        list2.add("原神");
        list2.add("崩坏3");
        list2.add("星穹铁道");
        list2.add("绝区零");
        list.addAll(list2);//给list添加list2
        list.addAll(1,list2);//从list的1索引处添加list2
        System.out.println("addAll后list="+list);
        //8.containsAll list是否包含list2全部元素
        System.out.println(list.containsAll(list2));
        //9.removeAll
        list.removeAll(list2);
        System.out.println("removeAll后list="+list);

    }
}
