package c1_internetProgroming.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive {
    public static void main(String[] args) throws Exception{
        //创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(9999);
        //创建DatagramPacket对象
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        socket.receive(packet);//此处阻塞,等待发送端发送的消息
        //消息拆包
        byte[] data = packet.getData();
        String message = new String(data,0, packet.getLength());
        String ip = packet.getAddress().getHostName();
        System.out.println("接收到"+ip+"发来的消息"+message);
        //释放资源
        socket.close();

    }
}
