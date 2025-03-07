package c1_internetProgroming.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(99);
        System.out.println("service start,waiting for client");
        Socket socket = server.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        String message = new String(bytes, 0, len);

        String ip = socket.getInetAddress().getHostName();

        System.out.println(ip+":"+message);

        outputStream.write("hello too".getBytes());

        socket.close();
        server.close();



    }
}
