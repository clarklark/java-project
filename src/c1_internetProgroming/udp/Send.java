package c1_internetProgroming.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args) throws Exception{
        //创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(8888);
        String message = "你的女朋友在你那里,后面忘了,在我这里可是后面也忘了";

        byte[] bytes = message.getBytes();
        //创建DatagramPacket对象
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length
                , InetAddress.getByName("127.0.0.1"), 9999);
        //发送消息
        socket.send(packet);
        //释放资源
        socket.close();

    }
}
