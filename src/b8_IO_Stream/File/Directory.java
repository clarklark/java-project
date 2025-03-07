package b8_IO_Stream.File;


import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory {
    public static void main(String[] args) {

    }

    @Test
    public void m1() {
        String filePath = "G:\\demo\\a\\b";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println(filePath+"存在");
        }else{
            if (file.mkdirs()) {//创建一级目录使用mkdir(),多级目录用mkdirs()
                System.out.println(filePath+"创建成功");
            } else {
                System.out.println(filePath+"创建失败");
            }
        }
    }
}