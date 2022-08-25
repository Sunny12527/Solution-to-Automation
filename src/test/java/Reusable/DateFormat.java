package Reusable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static String StringToDateFormat(String RDate) throws ParseException {
        java.text.DateFormat formatter = new SimpleDateFormat("MMMM dd yyyy");
        java.util.Date date = (Date)formatter.parse(RDate);
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy");
        String finalDate = newFormat.format(date);
        return finalDate;
    }
}

