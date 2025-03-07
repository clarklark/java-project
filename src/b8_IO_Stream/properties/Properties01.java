package b8_IO_Stream.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("test2.txt"));
        String line = "";
        while((line = reader.readLine())!=null){
            String[]split = line.split(" = ");
            System.out.println(split[0]+ " = "+split[1]);
        }
        reader.close();
    }
}
