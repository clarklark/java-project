package c1_internetProgroming.udp.chatRoom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(1);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String message = scanner.nextLine();
            if("886".equals(message)){
                break;
            }
            DatagramPacket packet = new DatagramPacket(
                    message.getBytes()
                    , message.getBytes().length
                    , InetAddress.getByName("127.0.0.1")
                    , 2);
            socket.send(packet);
        }
        socket.close();
    }
}
