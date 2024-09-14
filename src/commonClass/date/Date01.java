package commonClass.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args){
        //获取当前系统时间
        Date date = new Date();
        //Tue Jun 11 14:33:50 CST　2024

        //指定格式  //HH 24小时制 hh 12小时制 SS 毫秒
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

        System.out.println("当前日期"+simpleDateFormat.format(date));


    }
}
