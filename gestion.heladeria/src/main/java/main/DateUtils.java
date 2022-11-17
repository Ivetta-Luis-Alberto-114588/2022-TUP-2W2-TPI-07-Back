package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String DATE_FORMAT_DB = "yyyy/MM/dd";
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat(DATE_FORMAT);
    private static final SimpleDateFormat FORMATTER_DB = new SimpleDateFormat(DATE_FORMAT);

    public static Date stringToDate(String date){
        try {
            return FORMATTER.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String dateToString(Date date){
        return FORMATTER.format(date);
    }

    public static Date stringToDateDB(String date){
        try {
            return FORMATTER_DB.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String dateToStringDB(Date date){
        return FORMATTER_DB.format(date);
    }

}
