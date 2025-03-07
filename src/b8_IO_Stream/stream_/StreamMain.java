package b8_IO_Stream.stream_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("段哲");
        list.add("段贵友");
        list.add("杜泽瑞");
        list.add("杜威成");
        list.add("杜小东");
        list.add("杜微");
        list.stream().filter(str->str.startsWith("杜"))
                .filter(s -> s.length()==3)
                .forEach(System.out::println);

        int []arr = {1,2,3,4};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);

        Stream<Integer> st = Stream.of(1,2,3,4,5);
        st.forEach(System.out::println);
    }
}
