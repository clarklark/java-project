package b8_IO_Stream.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {


        String filePath ="test_file\\test.txt";
        //1.new FileInputStream 转成 InputStreamReader 再转成 BufferedReader
        //2.指定 gbk
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                new FileInputStream(filePath),"gbk"));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();


    }
}
