package b5_collection.map;

import java.util.Comparator;
import java.util.TreeMap;
@SuppressWarnings("all")
public class TreeMap01 {
    public static void main(String[] args) {
        TreeMap treeMap=new TreeMap(new Comparator(){
            @Override
                public int compare(Object o1,Object o2){
                return ((String)o1).length()- ((String)o2).length();
        }
        });
        treeMap.put("011","rick");
        treeMap.put("0222","tommy");
        treeMap.put("03","jerry");
        treeMap.put("04","clark");//treeMap内部比较机制,compare返回值相同,无法加入
        System.out.println(treeMap);
    }
}
