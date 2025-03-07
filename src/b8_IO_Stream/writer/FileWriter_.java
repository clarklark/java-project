package b8_IO_Stream.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "test_file\\test.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath,true);
            fileWriter.write("\nI love FangNai as well!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //fileWriter.flush();
                //关闭文件流,等价于flush+关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
