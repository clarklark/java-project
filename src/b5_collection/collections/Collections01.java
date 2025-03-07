package b5_collection.collections;

import java.util.*;

@SuppressWarnings("all")
public class Collections01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jerry");
        list.add("jack");
        list.add("jason");
        list.add("rick");

        System.out.println(list);
        //1.反转
        Collections.reverse(list);
        System.out.println("1.反转" + list);
        //2.自然排序(字母)
        Collections.sort(list);
        System.out.println("2.自然排序" + list);
        //3.按指定数值排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("3.按指定数值排序" + list);
        //4.交换两个位置元素
        Collections.swap(list, 1, 2);
        System.out.println("4.交换两个位置元素" + list);
        //5.自然排序最大值
        System.out.println("5.自然排序最大元素" + Collections.max(list));

        //6.自定义比较方式最大值
        Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                    return ((String) o1).length() - ((String) o2).length();
                }
            });
            System.out.println("6.长度最大元素" + Collections.max(list));
        //7.拷贝
        List dest=new ArrayList();
        for(int i=0;i<4;i++){
            dest.add("ben"+i);
        }
        Collections.copy(list,dest);
        System.out.println("7.拷贝后list"+list+"\n拷贝后dest"+dest);
        //8.用新值替换所有旧值
        Collections.replaceAll(list,"ben1","deal");
        System.out.println("8.用新值替换所有旧值"+list);
    }
}
