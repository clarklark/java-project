package commonClass.date;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDate01 {
    public static void main(String[] args) {
        LocalDate ld=LocalDate.now();
        System.out.println(ld);
        System.out.println(ld.getYear());
        System.out.println(ld.getDayOfYear());
        System.out.println(ld.getDayOfWeek());

        LocalDateTime ldt= LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getHour());

        LocalDateTime localDateTime=ldt.plusHours(110);
        System.out.println("110h后"+localDateTime);
        LocalDate localDate=ld.plusDays(110);
        System.out.println("110天后"+localDate);
    }
}
