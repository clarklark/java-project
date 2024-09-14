package commonClass.date;

import java.time.Instant;
import java.util.Date;

public class Instant01 {
    public static void main(String[] args) {
        Instant now=Instant.now();
        System.out.println(now);

        //Instant->Date
        Date date=Date.from(now);
        //Date->Instant
        Instant instant=date.toInstant();
    }
}
