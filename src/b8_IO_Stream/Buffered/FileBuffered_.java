package b8_IO_Stream.Buffered;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileBuffered_ {
    // 使用BufferedReader读取文件内容
    public static void readUsingBufferedReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用BufferedWriter写入文件内容
    public static void writeUsingBufferedWriter(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // 写入字符串到文件
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 使用Files.copy复制文件
    public static void copyFileUsingFiles(String sourcePath, String destPath) {
        try {
            // 复制源文件到目标路径
            Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 假设有一个文件路径
        String filePath = "example.txt";
        String content = "这是要写入文件的内容。\n这是第二行。";

        // 写入文件
        writeUsingBufferedWriter(filePath, content);

        // 读取文件
        readUsingBufferedReader(filePath);

        // 复制文件
        String destPath = "example_copy.txt";
        copyFileUsingFiles(filePath, destPath);
    }
}
