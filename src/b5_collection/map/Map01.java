package b5_collection.map;

import java.util.HashMap;
import java.util.Map;
@SuppressWarnings("all")
public class Map01 {
    public static void main(String[] args) {

        /*
        1.Map和Collection并列存在,保存具有映射关系的数据 Key-Value(双列元素)
        2.Map中的key和value可以是任何引用类型的数据,会封装到HashMap$Node中
        3.Map中的key不允许重复
        4.Map中的value可以重复
        5.Map中的key和value都可以为null,
         key为null只能有一个,value为null可以有多个
        6.常用String类型作为Map的key
        7.key和value存在一一对应关系,既可以通过指定key找到对应value
        8.k-v封装到HashMap$Node中,因为Node实现了Entry接口
        所以有些书也说一对k-v就是一个Entry
         */
        Map map=new HashMap();
        map.put("no.1","jerry");
        map.put("no.2","tom");
        map.put("no.1","rick");//有相同的key,相当于等价替换
        System.out.println(map);

    }
}
