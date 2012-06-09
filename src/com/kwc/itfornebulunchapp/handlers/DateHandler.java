package com.kwc.itfornebulunchapp.handlers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * DateHandler.
 * @since 1.0
 * @author Marius Kristensen
 */

public final class DateHandler {
    private DateHandler() {
    }

    public static int getWeekDayByNumber() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * dayOfTheWeek.
     * This method finds todays weekday and translates it to the corresponding
     * norwegian date
     * @return
     */
//    private static HashMap<Integer, String> dayOfTheWeek() {
     private static int dayOfTheWeek() {

         Calendar cal = new GregorianCalendar();

         HashMap<Integer, String> m = new HashMap<Integer, String>();
         m.put(2, "mandag");
         m.put(3, "tirsdag");
         m.put(4, "onsdag");
         m.put(5, "torsdag");
         m.put(6, "fredag");
         m.put(7, "lørdag");
         m.put(1, "søndag");
         //Calendar cal = Calendar.getInstance();
         int day = cal.get(Calendar.DAY_OF_WEEK);

        return day;
     }

    /**
     * Generates the timestamp used to display when the lunch menu was
     * downloaded.
     * @return String with the format dd.MM.YYYY HH:mm:ss.
     */
    public static String timestamp() {
        String format = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
}
