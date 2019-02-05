package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
    Date date = new Date();
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formatted = format.format(date);
        System.out.println(formatted);
        format.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        formatted = format.format(date);
        System.out.println(formatted);
    }
}
