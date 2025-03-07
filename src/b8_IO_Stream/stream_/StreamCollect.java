package b8_IO_Stream.stream_;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
一行代码实现转化String为Map并且筛选19岁以上
 */
public class StreamCollect {
    public static void main(String[] args) {
        List<String> list = Stream.of("clark,19","rick,20","jerry,20").toList();
        Map<String, Integer> map = list.stream()
                .filter(s -> (Integer.parseInt(s.split(",")[1]) > 19))
                .collect(Collectors.toMap(
                        s -> s.split(",")[0],
                        s -> Integer.parseInt(s.split(",")[1])
                ));
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());

        }

    }
}
