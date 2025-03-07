package b8_IO_Stream.writer;

import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcPath = "test_file\\test.jpg";
        String desPath = "test2.jpg";
        BufferedInputStream br = null;
        BufferedOutputStream bw = null;
        int readLen = 0;
        try{
            br = new BufferedInputStream(new FileInputStream(srcPath));
            bw = new BufferedOutputStream(new FileOutputStream(desPath));
            byte[]buf= new byte[1024];
           while((readLen = br.read(buf))!=-1){
               bw.write(buf,0,readLen);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
