package b8_IO_Stream.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter1 = new PrintWriter(new FileWriter("test2.txt"));
        printWriter1.print("aiaiai");
        printWriter1.close();//flush+close才会关闭
    }
}
