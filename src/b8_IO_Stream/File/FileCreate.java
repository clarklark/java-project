package b8_IO_Stream.File;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    public  void create01() {
        String filePath = "g:/code/java/high_levelNote/news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void create02(){
        File parentFile=new File("g:/code/java/high_levelNote/out");
        String fileName="new2.txt";
        File file=new File(parentFile,fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void create03(){
        String parentPath="g:/";
        String fileName="news3";
        File file=new File(parentPath,fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}