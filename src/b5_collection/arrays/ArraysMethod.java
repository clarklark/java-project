package b5_collection.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod {
    public static void main(String[] args) {
        Integer []arr={12,34,52,13,51,18,45 };
        //1.toString 遍历数组
        System.out.println("排序前"+Arrays.toString(arr));
        //2.sort 排序
        Arrays.sort(arr);
        System.out.println("排序后"+Arrays.toString(arr));

        //3.二分查找,必须有序,找不到就返回-1
        int index=Arrays.binarySearch(arr,34);
        System.out.println(index);
        //4.拷贝 拷贝n个元素进入新数组,若小于0,则抛出异常
        Integer []num=Arrays.copyOf(arr,arr.length-3);
        System.out.println(Arrays.toString(num));
        //5.填充 用某个数值填充数组
        Arrays.fill(num,99);
        System.out.println(Arrays.toString(num));

        //6.判断两个数组是否完全一致
        System.out.println(Arrays.equals(arr,num));

        //7.将数组转化成列表
        List<Integer> asList=Arrays.asList(1,2,5);

        System.out.println(asList);
        System.out.println("运行类型"+asList.getClass());

    }
}
