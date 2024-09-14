package exception;

import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        int num=0;
        String intStr="";
        Scanner scanner=new Scanner(System.in);

        while (true){
            System.out.println("请输入一个整数");
            intStr=scanner.next();
            try {
                num=Integer.parseInt(intStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
            }
        }
        System.out.println("你输入的整数是 "+num);

    }
}
