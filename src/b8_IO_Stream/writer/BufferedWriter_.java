package b8_IO_Stream.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "test_file\\test.txt";
        //new FileWriter(filePath,true)追加写入,反之覆盖
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.newLine();
        bufferedWriter.write("I also love HongXia!");
        bufferedWriter.close();

    }
}
