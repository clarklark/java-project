package b8_IO_Stream.reader;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {
        String filePath = "test_file\\test.txt";
        int readLen = 0;
        char[]buf = new char[8];
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            while((readLen = fileReader.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
