package c1_internetProgroming.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 99);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String message = new String(bytes, 0, len);

        System.out.println(message);

        socket.close();
    }
}
