package b8_IO_Stream.writer;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) {
        //不要用这个去读取二进制文件(doc,视频,图片)
        String srcPath = "test_file\\test.txt";
        String desPath = "test2.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try{
            br = new BufferedReader(new FileReader(srcPath));
            bw = new BufferedWriter(new FileWriter(desPath));
            while ((line = br.readLine())!=null){
                bw.write(line);
                bw.newLine();
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
