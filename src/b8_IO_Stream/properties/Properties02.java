package b8_IO_Stream.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("test2.txt"));

        properties.list(System.out);

        String wife =properties.getProperty("wife");
        String name = properties.getProperty("name");

    }
}
