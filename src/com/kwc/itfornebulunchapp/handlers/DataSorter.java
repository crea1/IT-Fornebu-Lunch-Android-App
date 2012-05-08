package com.kwc.itfornebulunchapp.handlers;

import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @since 1.0
 * @author Marius Kristensen
 */
public final class DataSorter {
    private DataSorter() {
    }
    /**
     * Regexp to find the menu in the html.
     * Searces for every span with class="menu_title",
     * and class="menu_body"
     */
    private static final String REGEXP_EXPRESSION = "<span class=\"menu_title\">"
                                + "(.*?)"
                                + "</span>.*?"
                                + "<span class=\"menu_body\"><p>"
                                + "(.*?)"
                                + "</p></span>";

    public static WeekMenu sortLunchData(String html) {
        WeekMenu theWeekMenu = new WeekMenu();
        HashMap<String, String> menu = new HashMap<String, String>();

        // Do regexp
        Pattern patt = Pattern.compile(REGEXP_EXPRESSION);
        Matcher matt = patt.matcher(html);
        while (matt.find()) {
            // put unsorted items into menu
            menu.put(matt.group(1).toLowerCase().trim(), matt.group(2));
        }

        // Sort list and put it in a menu
        theWeekMenu.setMonday(new DayMenu("Monday", menu.get("mandag"), 2));
        theWeekMenu.setTuesday(new DayMenu("Tuesday", menu.get("tirsdag"), 3));
        theWeekMenu.setWednesday(new DayMenu("Wednesday", menu.get("onsdag"), 4));
        theWeekMenu.setThursday(new DayMenu("Thursday", menu.get("torsdag"), 5));
        theWeekMenu.setFriday(new DayMenu("Friday", menu.get("fredag"), 6));

        return theWeekMenu;
    }
}
