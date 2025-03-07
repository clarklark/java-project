package b8_IO_Stream.outputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String srcPath = "G:\\code\\java\\note\\test_file\\test.jpg";
        String desPath = "G:\\code\\java\\note\\test2.jpg";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(desPath);

            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
