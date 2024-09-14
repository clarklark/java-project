package commonClass.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendar01 {
    public static void main(String[] args) {
        Calendar calendar=new GregorianCalendar();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.HOUR));
        //24小时制
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DATE));
        //程序员自己组合顺序
    }
}
