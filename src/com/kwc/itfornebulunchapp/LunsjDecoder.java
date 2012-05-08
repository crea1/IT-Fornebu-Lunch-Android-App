package com.kwc.itfornebulunchapp;

import com.kwc.itfornebulunchapp.model.DayMenu;
import com.kwc.itfornebulunchapp.model.WeekMenu;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: marhaukri
 * Date: 19.03.12
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
public class LunsjDecoder {

    private static WeekMenu getLunsj() {
        WeekMenu theWeekMenu = new WeekMenu();
        String url = "http://leietaker.itfornebu.no/itfornebu/kantinemeny";
        String line, s1 = "", s2 ="";
        StringBuilder content = new StringBuilder();
        HashMap<String,String> menu = new HashMap<String, String>();

        // Read url content into StringBuilder
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            //return "O'oh! Noe feilet under henting av lunsj";
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
        theWeekMenu.setMonday(new DayMenu("Monday",menu.get("mandag"),2));
        theWeekMenu.setTuesday(new DayMenu("Tuesday", menu.get("tirsdag"),3));
        theWeekMenu.setWednesday(new DayMenu("Wednesday", menu.get("onsdag"),4));
        theWeekMenu.setThursday(new DayMenu("Thursday", menu.get("torsdag"),5));
        theWeekMenu.setFriday(new DayMenu("Friday", menu.get("fredag"),6));

        return theWeekMenu;
    }

    /**
     * Formats the internal java menu-object to a Json-object.
     * @return JSON-formatted string.
     */
    public static String JSONWeekMenu() {
        WeekMenu menu = getLunsj();
        String s =
        "{"
        + "\"Monday\":\""+menu.getMonday().getDish()+"\","
        + "\"Tuesday\":\""+menu.getTuesday().getDish()+"\","
        + "\"Wednesday\":\""+menu.getWednesday().getDish()+"\","
        + "\"Thursday\":\""+menu.getThursday().getDish()+"\","
        + "\"Friday\":\""+menu.getFriday().getDish()+"\""
        + "}";
        return s;
    }


}
