package com.kwc.itfornebulunchapp.handlers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * DateHandler.
 * @since 1.0
 * @author Marius Kristensen
 */

public class DateHandler {

    public static int getWeekDayByNumber() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * dayOfTheWeek.
     * This method finds todays weekday and translates it to the corresponding
     * norwegian date
     * @return
     */
    private static HashMap<Integer, String> dayOfTheWeek() {
        Calendar cal = new GregorianCalendar();
        HashMap<Integer, String> m = new HashMap<Integer, String>();
        m.put(2, "mandag");
        m.put(3, "tirsdag");
        m.put(4, "onsdag");
        m.put(5, "torsdag");
        m.put(6, "fredag");
        m.put(7, "lørdag");
        m.put(1, "søndag");
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return m;
    }
}
