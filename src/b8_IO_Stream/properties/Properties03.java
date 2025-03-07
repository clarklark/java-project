package b8_IO_Stream.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        //文件无key创建,有key修改
        properties.setProperty("charset","utf-8");
        properties.setProperty("wife","grey");
        properties.setProperty("name","clark");

        properties.store(new FileOutputStream("test_file\\test.properties"),"Grey is cute nie");//后者是注释


    }
}
