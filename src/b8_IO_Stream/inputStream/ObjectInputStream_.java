package b8_IO_Stream.inputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String filePath = "test2.txt";

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readUTF());
        System.out.println(objectInputStream.readObject());

        objectInputStream.close();
    }
}
