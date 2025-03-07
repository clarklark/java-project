package b5_collection.map;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class MapMethod {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("rick",20);
        map.put("jerry",19);
        map.put("clark",18);
        map.put("tom",18);
        System.out.println(map);
        //移除key以及对应value
        map.remove("tom");
        System.out.println(map);
        //获取key对应value
        System.out.println(map.get("clark"));
        //map大小
        System.out.println(map.size());
        //map是否为空
        System.out.println(map.isEmpty());
        //map是否包含某个key
        System.out.println(map.containsKey("clark"));
        //清除
        map.clear();
        System.out.println(map);


    }
}
