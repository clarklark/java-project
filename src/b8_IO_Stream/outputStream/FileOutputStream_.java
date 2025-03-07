package b8_IO_Stream.outputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    // 逐字节写入文件
    public void writeFile01() {
        String filePath = "g:\\code\\java\\test.txt";
        FileOutputStream fileOutputStream = null;
        try {
            // 创建FileOutputStream对象，用于写入文件
            fileOutputStream = new FileOutputStream(filePath);
            // 写入单个字节
            fileOutputStream.write('H');
            fileOutputStream.write('e');
            fileOutputStream.write('l');
            fileOutputStream.write('l');
            fileOutputStream.write('o');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 使用字节数组批量写入文件
    public void writeFile02() {
        String filePath = "g:\\code\\java\\test.txt";
        FileOutputStream fileOutputStream = null;
        try {
            // 创建FileOutputStream对象，用于写入文件
            fileOutputStream = new FileOutputStream(filePath);
            // 要写入的字符串
            String str = "Hello, World!";
            // 将字符串转换为字节数组
            byte[] bytes = str.getBytes();
            // 写入字节数组
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
