package b8_IO_Stream.stream_;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("段哲");
        list.add("段贵友");
        list.add("杜泽瑞");
        list.add("杜威成");
        list.add("杜小东");
        list.add("杜微");

        //limit(n),取前n个元素
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();
        //skip(n),跳过n个元素
        list.stream().skip(2).forEach(s -> System.out.println(s));
        list.stream().skip(2).limit(2).forEach(s-> System.out.println(s));
        System.out.println();
        //concat()组合流
        Stream<String> s1 = list.stream().limit(4);
        Stream<String> s2 = list.stream().skip(2);
        Stream<String> s3 = Stream.concat(s1, s2);
        s3.forEach(System.out::println);
        System.out.println();
        //distinct(),消除想同的元素,依赖于hashCode和equals
        //s3.distinct().forEach(System.out::println); //报错,流被消费(使用后),流已经关闭
        //s1.distinct().forEach(System.out::println); //同理,s1被concat使用

    }
}
