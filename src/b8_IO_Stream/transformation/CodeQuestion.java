package b8_IO_Stream.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String filePath = "test_file\\test.txt";
        //默认utf-8编码
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
    }
}
