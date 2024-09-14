package collection_.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@SuppressWarnings("all")
public class Homework02 {
    public static void main(String[] args) {
        Map hashMap = new HashMap<>();
        hashMap.put("rick", 8000);
        hashMap.put("clark", 3000);
        hashMap.put("tom", 18000);

        hashMap.put("rick", 9000); // 更新rick的工资为9000
        System.out.println("==方法1==");
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            // 将获取的值转换为Integer，然后增加1000
            Integer newSalary = entry.getValue() + 1000;
            // 更新HashMap中的值
            entry.setValue(newSalary);
            System.out.println("name:" + entry.getKey() + "  sal:" + entry.getValue());
        }

        System.out.println("==方法2==");
        Set keySet=hashMap.keySet();
        for(Object key:keySet){
            hashMap.put(key,(Integer)hashMap.get(key)+100);
        }
        System.out.println(hashMap);
    }
}
