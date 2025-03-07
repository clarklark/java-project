package b8_IO_Stream.inputStream;


import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }
    public void readFile01() {
        String filePath = "g:\\code\\java\\test.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象,用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从改输入流读取一个字节的数据,如果没有输入可用,此方法将阻止.
            //如果返回-1,表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.println((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile02() {
        String filePath = "g:\\code\\java\\test.txt";
        int readData = 0;
        int readLen = 0;
        byte[] buf = new byte[8];//一次读取8字节
        java.io.FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象,用于读取文件
            fileInputStream = new java.io.FileInputStream(filePath);
            //从改输入流读取最多b.length字节的数据,此方法将阻塞,直到某些输入可用
            //如果返回-1,表示读取完毕
            //如果读取正常,返回实际读取的字节
            while ((readLen=fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
