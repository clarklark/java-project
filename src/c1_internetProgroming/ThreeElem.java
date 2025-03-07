package c1_internetProgroming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 3要素
 */
/*
1.      ip:设备在网络中唯一标识
1.1     ipv4 (主要)
        32位二进制地址长度,分成4组
        2^32次方
1.1.2   ipv4的分类
        公网地址(万维网)和私有地址(局域网)
        192.168.开头为私有地址
        范围192.168.0,0--192.168.255.255
        127.0.0.1 也可以是loaclhost,也称本机IP,永远只会寻找但其那所在本机
        cmd命令
        ipconfig: 查看本机IP地址
        ping:检查网络是否连通
1.2     ipv6 互联网通信协议第六版
        128位 分成8组 用冒峰十六进制表示法
2.      端口,程序在设备中的唯一标识
        端口号:两个字节表示的整数0-65535(2^16)
3.      协议,数据在网络中传输的规则
3.1     UDP (User Datagram Protocol)
        速度快,有大小限制64k/次,数据不安全,容易丢失数据

3.2     TCP (Transmission Control Procter)
        速度慢,无大小限制,数据安全


*/

public class ThreeElem {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("198.126.10.1");//也可以是主机名

        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());


    }
}
