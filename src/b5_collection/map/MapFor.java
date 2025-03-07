package b5_collection.map;

import java.util.*;

@SuppressWarnings("all")
public class MapFor {
    public static void main(String[] args) {
        Map<Object,Object> map=new HashMap();
        map.put("no.1","jerry");
        map.put("no.2","tom");
        map.put("no.3","ben");
        map.put("no.4","rick");
        //三种方法,分别是从 <key> <键值对> <value> 三个输入

        //1.先取出所有key,通过key取出对应的value
        System.out.println("====1.增强for遍历====");
        for(Object key:map.keySet()){
            System.out.println(key+"-"+map.get(key));
        }
        System.out.println("====1.迭代器遍历====");
        Iterator iterator1= map.keySet().iterator();
        while(iterator1.hasNext()){
            Object key=iterator1.next();
            System.out.println(key+"-"+map.get(key));
        }

        //2.把所有values取出来
        System.out.println("====2.增强for遍历====");
        for(Object value:map.values()){
            System.out.println(value);
        }
        System.out.println("====2.迭代器遍历====");
        Iterator iterator2= map.values().iterator();
        while(iterator2.hasNext()){
            Object value=iterator2.next();
            System.out.println(value);
        }

        //3.通过EntrySet获取k-v
        System.out.println("====3.增强for遍历====");
        for(Map.Entry<Object,Object>entry:map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        System.out.println("====3.迭代器遍历====");
        Iterator iterator3= map.entrySet().iterator();
        while(iterator3.hasNext()){
            Object entry=iterator3.next();
            Map.Entry m=(Map.Entry)entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }


    }
}
