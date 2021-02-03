package Test5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Testttttt {
    public static void daysBetween2Dates() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date1=null;
        Date date2=null;
        // Định nghĩa 2 mốc thời gian ban đầu
        try {
            date1 = dateFormat.parse("15-07-2000");
            date2 = dateFormat.parse("15-08-2000");
        }catch (ParseException e){
            e.printStackTrace();
        }
        c1.setTime(date1);
        c2.setTime(date2);
        // Công thức tính số ngày giữa 2 mốc thời gian:
        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        System.out.print("Số ngày giữa " + dateFormat.format(c1.getTime())
                + " và " + dateFormat.format(c2.getTime()) + ": ");
        System.out.println(noDay);
    }

    public static void main(String[] args) {
        daysBetween2Dates();
    }
}
