package b8_IO_Stream.printstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;

        out.write("I love YouLi".getBytes());

        out.close();

        //修改out的输出位置
        System.setOut(new PrintStream("test2.txt"));
        System.out.println("Hello,world!");
    }
}
