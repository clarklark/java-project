package c1_internetProgroming.udp.chatRoom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args)throws Exception {
        DatagramSocket socket = new DatagramSocket(2);
        System.out.println("聊天室开启");
        while (true){
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
            socket.receive(packet);
            byte[] data = packet.getData();
            String ip = packet.getAddress().getHostName();
            String message = new String(data,0, packet.getLength());
            System.out.println(ip+":"+message);
        }

    }
}
