package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static String returnNextMonth(){
        // Creating Date Object
        Date dNow = new Date();

        //Creating calendar Object
        Calendar calendar = new GregorianCalendar();

        // Set Calendar date to current date
        calendar.setTime(dNow);

        // Create object of simple date format
        // Defining Date format to example: (Feb-2022)
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");

        // Incrementing the current month
        calendar.add(Calendar.MONTH,1);

        // Generating date based on the specified format
        String date = sdf.format(calendar.getTime());

        return date;
    }
}
