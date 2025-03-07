package b8_IO_Stream.stream_;

import java.util.stream.Stream;

/**
 * Stream的终结方法
 * 1.void forEach()
 * 2.long count()
 */
public class StreamEnd {
    public static void main(String[] args) {
        long count = Stream.of(1, 3, 4, 6, 7, 4, 12, 9).filter(s -> s>=Math.PI).count();
        System.out.println(count);
    }
}
