package collection_.map;

import java.util.*;

@SuppressWarnings("all")
public class MapFor {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("no.1","jerry");
        map.put("no.2","tom");
        map.put("no.3","ben");
        map.put("no.4","rick");

        //1.先取出所有key,通过key取出对应的value
        Set keySet=map.keySet();
        System.out.println("====1.增强for遍历====");
        for(Object key:keySet){
            System.out.println(key+"-"+map.get(key));
        }
        System.out.println("====1.迭代器遍历====");
        Iterator iterator1= keySet.iterator();
        while(iterator1.hasNext()){
            Object key=iterator1.next();
            System.out.println(key+"-"+map.get(key));
        }
        //2.把所有values取出来
        //可以使用所有Collections的遍历方法
        Collection values=map.values();
        System.out.println("====2.增强for遍历====");
        for(Object value:values){
            System.out.println(value);
        }
        System.out.println("====2.迭代器遍历====");
        Iterator iterator2= values.iterator();
        while(iterator2.hasNext()){
            Object value=iterator2.next();
            System.out.println(value);
        }

        //3.通过EntrySet获取k-v
        Set entrySet=map.entrySet();
        System.out.println("====3.增强for遍历====");
        for(Object entry:entrySet){
            //将entry转化为Map.Entry
            Map.Entry m=(Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
        System.out.println("====3.迭代器遍历====");
        Iterator iterator3= entrySet.iterator();
        while(iterator3.hasNext()){
            Object entry=iterator3.next();
            Map.Entry m=(Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }


    }
}
