package com.kwc.itfornebulunchapp;

import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * LunsjDecoder.
 * @since 1.0
 * @author Marius Kristensen
 */

public class LunsjDecoder {

    /**
     * This method reads the HTML from the Lunch page at itfornebu.no
     * and searches for the menu using a regexp. It then sorts the
     * data to the different weekdays.
     * @return WeekMenu object
     */
    private static WeekMenu getLunsj() {
        WeekMenu theWeekMenu = new WeekMenu();
        String url = "http://leietaker.itfornebu.no/itfornebu/kantinemeny";
        String line;
        StringBuilder content = new StringBuilder();
        HashMap<String, String> menu = new HashMap<String, String>();

        // Read url content into StringBuilder
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            return null;
        }

        // Regexp to find related html
        String expr = "<span class=\"menu_title\">"
                + "(.*?)"
                + "</span>.*?"
                + "<span class=\"menu_body\"><p>"
                + "(.*?)"
                + "</p></span>";
        Pattern patt = Pattern.compile(expr);
        Matcher matt = patt.matcher(content.toString());
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

    /**
     * Formats the internal java menu-object to a Json-object.
     * @return JSON-formatted string.
     */
    public static String jsonWeekMenuFormatter() {
        WeekMenu menu = getLunsj();
        String s =
        "{"
        + "\"Monday\":\"" + menu.getMonday().getDish() + "\","
        + "\"Tuesday\":\"" + menu.getTuesday().getDish() + "\","
        + "\"Wednesday\":\"" + menu.getWednesday().getDish() + "\","
        + "\"Thursday\":\"" + menu.getThursday().getDish() + "\","
        + "\"Friday\":\"" + menu.getFriday().getDish() + "\""
        + "}";
        return s;
    }


}
