package com.kwc.itfornebulunchapp.service;

import com.kwc.itfornebulunchapp.controllers.DataFetcher;
import com.kwc.itfornebulunchapp.controllers.DataSorter;
import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * This is a service class providing data to views.
 *
 * @author Marius Kristensen
 * @since 1.3
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
