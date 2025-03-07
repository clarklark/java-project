package b8_IO_Stream.reader;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_ {
    public static void main(String[] args) throws Exception {
        String filPath = "test_file\\test.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filPath));

        String line;
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
