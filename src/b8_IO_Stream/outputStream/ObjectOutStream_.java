package b8_IO_Stream.outputStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception{

        String filePath = "test2.txt";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        objectOutputStream.write(100);//int ->Integer,(实现Serializable)
        objectOutputStream.writeUTF("clark");
        objectOutputStream.writeObject(new Dog(7,"jerry"));

        objectOutputStream.close();
    }
}
class Dog implements Serializable{
    int age;
    String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }
}


