package com.kwc.itfornebulunchapp.service;

import com.kwc.itfornebulunchapp.handlers.DataFetcher;
import com.kwc.itfornebulunchapp.handlers.DataSorter;
import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: crea
 * Date: 12/22/12
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeekMenuService {
    /**
     * This method reads the HTML from the Lunch page at itfornebu.no
     * and searches for the menu using a regexp. It then sorts the
     * data to the different weekdays.
     * @return WeekMenu object
     */
    public WeekMenu getWeekMenu() {
        // Get HTML
        String content = DataFetcher.fetchHTML();

        if (content != null) {
            return DataSorter.sortLunchData(content);
        } else {
            //todo add some error handling here.
            return null;
        }
    }
    public DayMenu getTodaysDish() {
        WeekMenu weekMenu = getWeekMenu();
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_WEEK);
        DayMenu dish = null;

        if (weekMenu != null) {
            switch (day) {
                case Calendar.MONDAY:
                    dish = weekMenu.getMonday();
                    break;
                case Calendar.TUESDAY:
                    dish = weekMenu.getTuesday();
                    break;
                case Calendar.WEDNESDAY:
                    dish = weekMenu.getWednesday();
                    break;
                case Calendar.THURSDAY:
                    dish = weekMenu.getThursday();
                    break;
                case Calendar.FRIDAY:
                    dish = weekMenu.getFriday();
                    break;
                case Calendar.SATURDAY:
                    dish = new DayMenu("Lørdag", "Kantinen er stengt i dag.", Calendar.SATURDAY);
                    break;
                case Calendar.SUNDAY:
                    dish = new DayMenu("Søndag", "Kantinen er stengt i dag.", Calendar.SUNDAY);
                    break;
                default:
            }
        }
        return dish;
    }
}
