package b8_IO_Stream.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "test2.txt";
        String charSet = "utf-8";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream(filePath),charSet
        );

        outputStreamWriter.write("I love YuanYi");
        outputStreamWriter.close();

    }
}
